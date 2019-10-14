package com.product.dto;

import java.io.Serializable;

public class CredentialsDTO implements Serializable {
    private String email;
    private String password;

    public CredentialsDTO() {}

    public String getEmail() {
        return email;
    }

    public CredentialsDTO setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CredentialsDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
