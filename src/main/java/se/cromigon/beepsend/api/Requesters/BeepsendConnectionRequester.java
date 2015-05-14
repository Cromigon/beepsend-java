package se.cromigon.beepsend.api.Requesters;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.Endpoints;
import se.cromigon.beepsend.api.connection.Callback;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;

public class BeepsendConnectionRequester {

    private class UpdateRequestBody {
        private Callback callbacks;
        private String system_id;
        private String label;
        private String description;

        public UpdateRequestBody(Callback callbacks, String system_id, String label, String description) {
            this.callbacks = callbacks;
            this.system_id = system_id;
            this.label = label;
            this.description = description;
        }

        public Callback getCallbacks() {
            return callbacks;
        }

        public String getSystem_id() {
            return system_id;
        }

        public String getLabel() {
            return label;
        }

        public String getDescription() {
            return description;
        }
    }

    public BeepsendConnectionRequester() {}

    private HttpEntity<String> generateHttpEntity(String api_token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>("parameters", headers);
    }

    private HttpEntity<UpdateRequestBody> generateHttpEntity(String api_token, Connection connection) {
        UpdateRequestBody updateRequestBody = new UpdateRequestBody(connection.getCallbacks(), connection.getSystem_id(),
                connection.getLabel(), connection.getDescription());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(updateRequestBody, headers);
    }

    public Connection[] getConnections(String api_token) throws ApiTokenInvalidException, HttpClientErrorException {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<Connection[]> response = restTemplate.exchange(Endpoints.BASE_URL + Endpoints.CONNECTIONS,
                    HttpMethod.GET, entity, Connection[].class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public Connection getMyConnection(String api_token) throws ApiTokenInvalidException, HttpClientErrorException {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<Connection> response = restTemplate.exchange(Endpoints.BASE_URL + Endpoints.CONNECTIONS_ME, HttpMethod.GET, entity, Connection.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public Connection getConnectionById(String api_token, Integer id) throws ApiTokenInvalidException,
            HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = generateHttpEntity(api_token);

        try {
            ResponseEntity<Connection> response = restTemplate.exchange(Endpoints.BASE_URL + String.format(Endpoints.CONNECTIONS_ID, id), HttpMethod.GET, entity, Connection.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }

    public Connection updateConnection(String api_token, Connection connection) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<UpdateRequestBody> entity = generateHttpEntity(api_token, connection);
        try {
            ResponseEntity<Connection> response = restTemplate.exchange(Endpoints.BASE_URL +
                    String.format(Endpoints.CONNECTIONS_ID, connection.getId()), HttpMethod.PUT, entity,
                    Connection.class);
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
