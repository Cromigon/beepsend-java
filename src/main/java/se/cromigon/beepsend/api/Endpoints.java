package se.cromigon.beepsend.api;


public interface Endpoints {
    String BASE_URL = "https://api.beepsend.com/2";
    String CONNECTIONS = "/connections/";
    String CONNECTIONS_ME = "/connections/me";
    String CONNECTIONS_ID = "/connections/%d";
    String CONNECTIONS_ID_TOKENRESET = "/connections/%d/tokenreset";
    String CONNECTIONS_ID_PASSWORDRESET = "/connections/%d/passwordreset";
    String NUMBERS = "/numbers/";
    String NUMBERS_ID = "/numbers/%d";
}
