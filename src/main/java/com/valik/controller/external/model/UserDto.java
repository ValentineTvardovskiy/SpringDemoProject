package com.valik.controller.external.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valik.model.User;

import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    private String email;
    private String token;
    @NotNull
    @JsonIgnore
    private String password;
    private String verifiedPassword;
    private String firstName;
    private String lastName;

    public UserDto() {
    }

    private UserDto(String email, String token, String password, String verifiedPassword, String firstName, String lastName) {
        this.email = email;
        this.token = token;
        this.password = password;
        this.verifiedPassword = verifiedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getVerifiedPassword() {
        return verifiedPassword;
    }

    public void setVerifiedPassword(String verifiedPassword) {
        this.verifiedPassword = verifiedPassword;
    }

    public static UserDto of(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setToken(user.getToken());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
