package com.valik.controller.external.model;

import com.valik.validator.annotations.FieldMatch;

import javax.validation.constraints.NotNull;

@FieldMatch.Field({
        @FieldMatch(
                message = "Password doesn't match",
                field = "password",
                fieldMatch = "verifiedPassword"
        )
})

public class RegisterUserDto {

    @NotNull
    private String email;
    private String token;
    @NotNull
    private String password;
    private String verifiedPassword;
    private String firstName;
    private String lastName;

    public RegisterUserDto() {
    }

    private RegisterUserDto(String email, String token, String password, String verifiedPassword, String firstName, String lastName) {
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

    public static RegisterUserDto empty() {
        return new RegisterUserDto();
    }
}
