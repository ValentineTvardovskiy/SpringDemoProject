package com.valik.model;

import com.valik.controller.external.model.RegisterUserDto;

import javax.validation.constraints.NotNull;
import java.awt.image.RGBImageFilter;
import java.util.HashSet;
import java.util.Set;

public class User {

    private Long id;
    @NotNull
    private String email;
    private String token;
    @NotNull
    private String password;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(Long id, String email, String token, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static User of(RegisterUserDto userDto) {
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setToken(userDto.getToken());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
