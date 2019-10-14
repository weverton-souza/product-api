package com.product.domain;

import com.product.abstracts.AbstractDomain;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserAccess extends AbstractDomain {
    private String email;
    private String password;
    private String token;
    private String roles;

    public UserAccess() {}

    public String getEmail() {
        return email;
    }

    public UserAccess setEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccess setPassword(final String password) {
        this.password = password;
        return this;
    }

    public String getToken() {
        return token;
    }

    public UserAccess setToken(final String token) {
        this.token = token;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public UserAccess setRoles(final String roles) {
        this.roles = roles;
        return this;
    }
}

