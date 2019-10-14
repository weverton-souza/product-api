package com.product.security.configuration;

import com.product.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailImpl implements UserDetails {
    private String id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailImpl() {}

    public String getId() {
        return id;
    }

    public UserDetailImpl setId(final String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDetailImpl setEmail(final String email) {
        this.email = email;
        return this;
    }

    public UserDetailImpl setPassword(final String password) {
        this.password = password;
        return this;
    }

    public UserDetailImpl setAuthorities(final Set<Role> authorities) {
        this.authorities = authorities
                .stream()
                .map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList());
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
