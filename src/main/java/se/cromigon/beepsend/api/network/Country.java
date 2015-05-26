package se.cromigon.beepsend.api.network;

public class Country {

    private String name;
    private Integer prefix;
    private String code;

    public Country() {
    }

    public Country(String name, Integer prefix, String code) {
        this.name = name;
        this.prefix = prefix;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
