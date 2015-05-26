package se.cromigon.beepsend.api.number;

import se.cromigon.beepsend.api.connection.Connection;

public class Keyword {

    private String keyword;
    private Float price;
    private Connection connection;

    public Keyword() {
    }

    public Keyword(String keyword, Float price, Connection connection) {
        this.keyword = keyword;
        this.price = price;
        this.connection = connection;
    }

    public String getKeyword() {
        return keyword;
    }

    public Float getPrice() {
        return price;
    }

    public Connection getConnection() {
        return connection;
    }
}
