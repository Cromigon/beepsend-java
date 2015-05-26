package se.cromigon.beepsend.api.connection;

import se.cromigon.beepsend.api.user.User;
import se.cromigon.beepsend.api.user.Wallet;

import java.util.List;

public class Connection {
    private Integer id;
    private String system_id;
    private String label;
    private String api_token;
    private Callback callbacks;
    private User[] users;
    private Wallet wallet;
    private String customer;
    private String description;
    private Integer type;
    private List<String> whitelist;
    private Integer tlv_for_mcc_mnc;

    public Connection() {
    }

    public Connection(Integer id, String system_id, String label, String api_token, Callback callbacks,
                      User[] users, Wallet wallet, String customer, String description, Integer type,
                      List<String> whitelist, Integer tlv_for_mcc_mnc) {
        this.id = id;
        this.system_id = system_id;
        this.label = label;
        this.api_token = api_token;
        this.callbacks = callbacks;
        this.users = users;
        this.wallet = wallet;
        this.customer = customer;
        this.description = description;
        this.type = type;
        this.whitelist = whitelist;
        this.tlv_for_mcc_mnc = tlv_for_mcc_mnc;
    }

    public Integer getId() {
        return id;
    }

    public String getSystem_id() {
        return system_id;
    }

    public String getLabel() {
        return label;
    }

    public String getApi_token() {
        return api_token;
    }

    public Callback getCallbacks() {
        return callbacks;
    }

    public User[] getUsers() {
        return users;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDescription() {
        return description;
    }

    public Integer getType() {
        return type;
    }

    public List<String> getWhitelist() {
        return whitelist;
    }

    public Integer getTlv_for_mcc_mnc() {
        return tlv_for_mcc_mnc;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) { this.label = name; }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public void setCallbacks(Callback callbacks) {
        this.callbacks = callbacks;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setWhitelist(List<String> whitelist) {
        this.whitelist = whitelist;
    }

    public void setTlv_for_mcc_mnc(Integer tlv_for_mcc_mnc) {
        this.tlv_for_mcc_mnc = tlv_for_mcc_mnc;
    }
}
