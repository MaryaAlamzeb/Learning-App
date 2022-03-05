package com.example.kids_game;

public class usersbo {
    private long id;
    private String name,email,password;

    public usersbo(long id, String name, String email) {
        this.id=id;
        this.email=email;
        this.name=name;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public usersbo()
{
    return;
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id +". "+name + " (" +email+") ";
    }
}
