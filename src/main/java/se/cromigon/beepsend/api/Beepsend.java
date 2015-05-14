package se.cromigon.beepsend.api;

import org.springframework.web.client.HttpClientErrorException;
import se.cromigon.beepsend.api.Requesters.BeepsendConnectionRequester;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.exceptions.ApiTokenNotSetException;

public class Beepsend {

    private String api_token;
    private BeepsendConnectionRequester beepsendConnectionRequester;

    public Beepsend() {
        api_token = "";
        beepsendConnectionRequester = new BeepsendConnectionRequester();
    }

    public Beepsend(String api_token) {
        this.api_token = api_token;
        beepsendConnectionRequester = new BeepsendConnectionRequester();
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public Connection[] getConnections() throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendConnectionRequester.getConnections(getApi_token());
        }
    }

    public Connection getMyConnection() throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendConnectionRequester.getMyConnection(getApi_token());
        }
    }

    public Connection getConnectionById(Integer id) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException{
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendConnectionRequester.getConnectionById(getApi_token(), id);
        }
    }
}
