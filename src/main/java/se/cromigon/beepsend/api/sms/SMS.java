package se.cromigon.beepsend.api.sms;

public class SMS {

    private String id;
    private String to;
    private String message;
    private String from;
    private String encoding;
    private Integer receive_dlr;
    private Boolean auto_gsm7_conversion;

    public SMS() {
        this.encoding = "UTF-8";
        this.receive_dlr = 1;
        this.auto_gsm7_conversion = true;
    }

    public SMS(String to, String message, String from) {
        this.to = to;
        this.message = message;
        this.from = from;
        this.encoding = "UTF-8";
        this.receive_dlr = 1;
        this.auto_gsm7_conversion = true;
    }

    public String getId() {
        return id;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public String getEncoding() {
        return encoding;
    }

    public Integer getReceive_dlr() {
        return receive_dlr;
    }

    public Boolean getAuto_gsm7_conversion() {
        return auto_gsm7_conversion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setReceive_dlr(Integer receive_dlr) {
        this.receive_dlr = receive_dlr;
    }

    public void setAuto_gsm7_conversion(Boolean auto_gsm7_conversion) {
        this.auto_gsm7_conversion = auto_gsm7_conversion;
    }
}
