package se.cromigon.beepsend.api.network;

public class Mccmnc {

    private String mcc;
    private String mnc;

    public Mccmnc() {
    }

    public Mccmnc(String mcc, String mnc) {
        this.mcc = mcc;
        this.mnc = mnc;
    }

    public String getMcc() {
        return mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }
}
