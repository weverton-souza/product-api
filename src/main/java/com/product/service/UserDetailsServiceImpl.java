package com.product.service;

import com.product.repository.IUserAccessRepository;
import com.product.security.configuration.UserDetailImpl;
import com.product.domain.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private IUserAccessRepository repository;

    @Autowired
    UserDetailsServiceImpl(final IUserAccessRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetailImpl loadUserByUsername(final String user) throws UsernameNotFoundException {
        Optional<UserAccess> optionalUser = this.repository.findByEmail(user);

        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException(user);
        }

        return new UserDetailImpl()
                .setId(optionalUser.get().getId())
                .setEmail(optionalUser.get().getEmail())
                .setPassword(optionalUser.get().getPassword());
    }
}
