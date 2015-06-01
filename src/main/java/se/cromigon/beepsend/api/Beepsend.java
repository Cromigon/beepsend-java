package se.cromigon.beepsend.api;

import org.springframework.web.client.HttpClientErrorException;
import se.cromigon.beepsend.api.pricelist.PriceList;
import se.cromigon.beepsend.api.requesters.BeepsendConnectionRequester;
import se.cromigon.beepsend.api.requesters.BeepsendNumberRequester;
import se.cromigon.beepsend.api.requesters.BeepsendPriceListRequester;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.exceptions.ApiTokenNotSetException;
import se.cromigon.beepsend.api.number.Number;
import se.cromigon.beepsend.api.requesters.BeepsendSendSMSRequester;
import se.cromigon.beepsend.api.sms.SMS;

public class Beepsend {

    private String api_token;
    private BeepsendConnectionRequester beepsendConnectionRequester;
    private BeepsendNumberRequester beepsendNumberRequester;
    private BeepsendPriceListRequester beepsendPriceListRequester;
    private BeepsendSendSMSRequester beepsendSendSMSRequester;

    public Beepsend() {
        api_token = "";
        beepsendConnectionRequester = new BeepsendConnectionRequester();
        beepsendNumberRequester = new BeepsendNumberRequester();
        beepsendPriceListRequester = new BeepsendPriceListRequester();
        beepsendSendSMSRequester = new BeepsendSendSMSRequester();
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

    public Number getNumberById(Integer id) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendNumberRequester.getNumberById(getApi_token(), id);
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

    public SMS sendSMS(SMS sms, Connection connection) throws ApiTokenNotSetException, ApiTokenInvalidException,
            HttpClientErrorException {
        if (api_token == "") {
            throw new ApiTokenNotSetException("The API Token is empty");
        } else {
            return beepsendSendSMSRequester.sendSMS(getApi_token(), sms, connection);
        }
    }
}
