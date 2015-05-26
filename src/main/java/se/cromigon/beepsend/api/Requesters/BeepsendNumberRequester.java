package se.cromigon.beepsend.api.Requesters;


import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.Endpoints;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.number.Number;

public class BeepsendNumberRequester {

    private HttpEntity<String> generateHttpEntity(String api_token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>("parameters", headers);
    }

    public Number[] getNumbers(String api_token) throws ApiTokenInvalidException,
            HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<Number[]> response = restTemplate.exchange(Endpoints.BASE_URL + Endpoints.NUMBERS,
                    HttpMethod.GET, entity, Number[].class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public Number getNumberById(String api_token, Integer id) throws ApiTokenInvalidException,
            HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<Number> response = restTemplate.exchange(Endpoints.BASE_URL +
                    String.format(Endpoints.NUMBERS_ID, id), HttpMethod.GET, entity, Number.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }
}
