package se.cromigon.beepsend.api;

import org.springframework.web.client.HttpClientErrorException;
import se.cromigon.beepsend.api.Pricelist.PriceList;
import se.cromigon.beepsend.api.Requesters.BeepsendConnectionRequester;
import se.cromigon.beepsend.api.Requesters.BeepsendNumberRequester;
import se.cromigon.beepsend.api.Requesters.BeepsendPriceListRequester;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.exceptions.ApiTokenNotSetException;
import se.cromigon.beepsend.api.number.Number;

public class Beepsend {

    private String api_token;
    private BeepsendConnectionRequester beepsendConnectionRequester;
    private BeepsendNumberRequester beepsendNumberRequester;
    private BeepsendPriceListRequester beepsendPriceListRequester;

    public Beepsend() {
        api_token = "";
        beepsendConnectionRequester = new BeepsendConnectionRequester();
        beepsendNumberRequester = new BeepsendNumberRequester();
        beepsendPriceListRequester = new BeepsendPriceListRequester();
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

    public Connection updateConnection(Connection connection) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendConnectionRequester.updateConnection(getApi_token(), connection);
        }
    }

    public Connection resetConnectionToken(Connection connection) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            setApi_token(beepsendConnectionRequester.connectionTokenReset(getApi_token()));
            connection.setApi_token(getApi_token());
            return connection;
        }
    }

    public String resetConnectionPassword(Connection connection) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendConnectionRequester.connectionPasswordReset(getApi_token());
        }
    }

    public Number[] getNumbers() throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendNumberRequester.getNumbers(getApi_token());
        }
    }

    public PriceList getMyPriceLists() throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendPriceListRequester.getMyCurrentPricelists(getApi_token());
        }
    }

    public PriceList getPriceListsByConnectionId(Integer id) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendPriceListRequester.getCurrentPriceListsByConnectionId(getApi_token(), id);
        }
    }

    public PriceList getPriceListsById(Integer id) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendPriceListRequester.getCurrentPriceListById(getApi_token(), id);
        }
    }

    public PriceList getPriceListsByLabel(String label) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendPriceListRequester.getCurrentPriceListByLabel(getApi_token(), label);
        }
    }
}
