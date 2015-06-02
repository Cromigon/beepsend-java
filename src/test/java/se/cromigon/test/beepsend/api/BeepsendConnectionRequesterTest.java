package se.cromigon.test.beepsend.api;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.Endpoints;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.requesters.BeepsendConnectionRequester;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;


public class BeepsendConnectionRequesterTest {

    private RestTemplate restTemplate;
    private BeepsendConnectionRequester beepsendConnectionRequester;
    private MockRestServiceServer mockServer;

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
        beepsendConnectionRequester = spy(new BeepsendConnectionRequester());
        doReturn(restTemplate)
                .when(beepsendConnectionRequester)
                .createRestTemplate();
    }

    @Test
    public void testGetConnectionsSuccessful() {
        String responseBody = "[{\"id\": 1, \"system_id\": \"beepsend\", \"label\": \"beepsend-connection\", " +
                "\"api_token\": \"abc123\", \"callbacks\": {\"dlr\": \"http://beepsend.com/dlr\", \"mo\": " +
                "\"https://beepsend.com/mocallback\", \"method\": \"PUT\"},\"users\": [{\"username\": " +
                "\"beepsend-user\", \"name\": \"Beep Beepson\", \"id\": 1}],\"wallet\": {\"balance\": 5028.14758, " +
                "\"name\": \"Beepsend wallet\", \"id\": 1},\"customer\": \"Beepsend AB\", \"description\": \"\", " +
                "\"type\": 1, \"whitelist\": [\"127.0.0.1\", \"10.11.12.13\", \"172.16.0.36\", \"192.168.1.170\"]," +
                "\"tlv_for_mcc_mnc\": 0}]";
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
        this.mockServer.expect(requestTo(Endpoints.BASE_URL + Endpoints.CONNECTIONS))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        Connection[] connections = beepsendConnectionRequester.getConnections("testtoken");
        this.mockServer.verify();
    }

    @Test(expected = ApiTokenInvalidException.class)
    public void testGetConnectionsNoToken() {
        String responseBody = "[{\"id\": 1, \"system_id\": \"beepsend\", \"label\": \"beepsend-connection\", " +
                "\"api_token\": \"abc123\", \"callbacks\": {\"dlr\": \"http://beepsend.com/dlr\", \"mo\": " +
                "\"https://beepsend.com/mocallback\", \"method\": \"PUT\"},\"users\": [{\"username\": " +
                "\"beepsend-user\", \"name\": \"Beep Beepson\", \"id\": 1}],\"wallet\": {\"balance\": 5028.14758, " +
                "\"name\": \"Beepsend wallet\", \"id\": 1},\"customer\": \"Beepsend AB\", \"description\": \"\", " +
                "\"type\": 1, \"whitelist\": [\"127.0.0.1\", \"10.11.12.13\", \"172.16.0.36\", \"192.168.1.170\"]," +
                "\"tlv_for_mcc_mnc\": 0}]";
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
        this.mockServer.expect(requestTo(Endpoints.BASE_URL + Endpoints.CONNECTIONS))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withUnauthorizedRequest());
        Connection[] connections = beepsendConnectionRequester.getConnections(null);
    }
}
