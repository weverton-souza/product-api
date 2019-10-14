package com.product.service;

import com.product.abstracts.AbstractService;
import com.product.dto.CredentialsDTO;
import com.product.repository.IUserAccessRepository;
import com.product.security.property.JwtConfiguration;
import com.product.domain.UserAccess;
import com.product.dto.UserAccessDTO;
import com.product.mapper.IUserAccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccessServiceImpl extends AbstractService<UserAccessDTO, String> {
    private final IUserAccessRepository accessRepository;
    private final IUserAccessMapper accessMapper;
    private final JwtConfiguration jwtConfiguration;
    private final BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserAccessServiceImpl(final IUserAccessRepository repository, final IUserAccessMapper mapper,
                                 final JwtConfiguration jwtConfiguration) {
        super(repository, mapper);
        this.accessRepository = repository;
        this.accessMapper = mapper;
        this.jwtConfiguration = jwtConfiguration;
    }

    @Override
    public UserAccessDTO saveOrUpdate(UserAccessDTO dto) {
        if(dto.getId() == null) {
            dto.setPassword(cryptPasswordEncoder.encode(dto.getPassword()));
        }
        return this.accessMapper.toDTO(this.accessRepository.save(this.accessMapper.toDomain(dto)));
    }

    public UserAccessDTO loadUserAccess(final CredentialsDTO credentials) {
        Optional<UserAccess> optUserAccess = this.accessRepository.findByEmail(credentials.getEmail());

        UserAccessDTO userAccess =
                this.accessMapper.toDTO(optUserAccess.orElseThrow(() -> new UsernameNotFoundException("")));
        return userAccess
                .setToken(successfulAuthentication(userAccess));
    }

    private String successfulAuthentication(final UserAccessDTO userAccess) {
        return this.jwtConfiguration.generateToken(userAccess.getEmail());
    }
}
