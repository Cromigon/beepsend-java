package se.cromigon.beepsend.api.number;

public class Number {

    private Integer id;
    private String number;
    private String country;
    private Keyword[] keywords;

    public Number() {
    }

    public Number(Integer id, String number, String country, Keyword[] keywords) {
        this.id = id;
        this.number = number;
        this.country = country;
        this.keywords = keywords;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public Keyword[] getKeywords() {
        return keywords;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setKeywords(Keyword[] keywords) {
        this.keywords = keywords;
    }
}
