package com.product.dto;

import com.product.abstracts.AbstractDataTransferObject;

public class UserAccessDTO extends AbstractDataTransferObject {
    private String email;
    private String password;
    private String token;
    private String roles;

    public UserAccessDTO() {}

    public String getEmail() {
        return email;
    }

    public UserAccessDTO setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccessDTO setPassword(final String password) {
        this.password = password;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserAccessDTO setToken(final String token) {
        this.token = token;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public UserAccessDTO setRoles(final String roles) {
        this.roles = roles;
        return this;
    }
}

