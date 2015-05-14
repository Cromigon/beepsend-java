package se.cromigon.beepsend.api.user;

public class User {

    private Integer id;
    private String name;
    private String username;

    public User() {
    }

    public User(Integer id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
