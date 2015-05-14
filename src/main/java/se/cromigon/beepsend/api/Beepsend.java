package se.cromigon.beepsend.api;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.exceptions.ApiTokenNotSetException;

public class Beepsend {

    private String api_token;

    public Beepsend() {
        api_token = "";
    }

    public Beepsend(String api_token) {
        this.api_token = api_token;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public Connection[] getConnections() throws ApiTokenNotSetException, ApiTokenInvalidException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Token " + getApi_token());
            HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
            try {
                ResponseEntity<Connection[]> response = restTemplate.exchange("https://api.beepsend.com/2/connections/", HttpMethod.GET, entity, Connection[].class);
                return response.getBody();
            } catch (HttpClientErrorException e) {
                if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                    throw new ApiTokenInvalidException("The API Token is invalid");
                }
            }
        }
        return null;
    }
}
