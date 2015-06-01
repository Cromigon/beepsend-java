package se.cromigon.beepsend.api.requesters;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.Endpoints;
import se.cromigon.beepsend.api.pricelist.PriceList;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;

public class BeepsendPriceListRequester {

    private HttpEntity<String> generateHttpEntity(String api_token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>("parameters", headers);
    }

    public PriceList getMyCurrentPricelists(String api_token) throws ApiTokenInvalidException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<PriceList> response = restTemplate.exchange(Endpoints.BASE_URL + Endpoints.CONNECTIONS_ME_PRICELISTS_CURRENT, HttpMethod.GET, entity, PriceList.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public PriceList getCurrentPriceListsByConnectionId(String api_token, Integer id) throws ApiTokenInvalidException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<PriceList> response = restTemplate.exchange(Endpoints.BASE_URL + String.format(Endpoints.CONNECTIONS_ID_PRICELISTS_CURRENT, id), HttpMethod.GET, entity, PriceList.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }
    public PriceList getCurrentPriceListById(String api_token, Integer id) throws ApiTokenInvalidException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<PriceList> response = restTemplate.exchange(Endpoints.BASE_URL + String.format(Endpoints.PRICELISTS_ID, id), HttpMethod.GET, entity, PriceList.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public PriceList getCurrentPriceListByLabel(String api_token, String label) throws ApiTokenInvalidException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<PriceList> response = restTemplate.exchange(Endpoints.BASE_URL + String.format(Endpoints.PRICELISTS_LABEL, label), HttpMethod.GET, entity, PriceList.class);
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
