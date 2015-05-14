package se.cromigon.beepsend.api.connection;

public class Callback {
    private String method;
    private String dlr;
    private String mo;

    public Callback() {
    }

    public Callback(String method) {
        this.method = method;
        this.dlr = "";
        this.mo = "";
    }

    public Callback(String method, String dlr, String mo) {
        this.method = method;
        this.dlr = dlr;
        this.mo = mo;
    }

    public String getMethod() {
        return method;
    }

    public String getDlr() {
        return dlr;
    }

    public String getMo() {
        return mo;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setDlr(String dlr) {
        this.dlr = dlr;
    }

    public void setMo(String mo) {
        this.mo = mo;
    }
}
