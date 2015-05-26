package se.cromigon.beepsend.api.network;

public class Network {

    private Mccmnc[] mccmnc;
    private String comment;
    private Float price;
    private Country contry;
    private String operator;

    public Network() {
    }

    public Network(Mccmnc[] mccmnc, String comment, Float price, Country contry, String operator) {
        this.mccmnc = mccmnc;
        this.comment = comment;
        this.price = price;
        this.contry = contry;
        this.operator = operator;
    }

    public Mccmnc[] getMccmnc() {
        return mccmnc;
    }

    public String getComment() {
        return comment;
    }

    public Float getPrice() {
        return price;
    }

    public Country getContry() {
        return contry;
    }

    public String getOperator() {
        return operator;
    }

    public void setMccmnc(Mccmnc[] mccmnc) {
        this.mccmnc = mccmnc;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setContry(Country contry) {
        this.contry = contry;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
