package se.cromigon.beepsend.api.user;

public class Wallet {
    private Integer id;
    private String name;
    private Float balance;

    public Wallet() {
    }

    public Wallet(Integer id, String name, Float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getBalance() {
        return balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
