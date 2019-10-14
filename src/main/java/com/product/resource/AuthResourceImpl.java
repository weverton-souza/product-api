package com.product.resource;

import com.product.dto.CredentialsDTO;
import com.product.dto.UserAccessDTO;
import com.product.generic.GenericResponse;
import com.product.service.UserAccessServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Api(value = "Auth", tags = "Auth")
@RequestMapping("/auth")
public class AuthResourceImpl {
    private final UserAccessServiceImpl service;

    public AuthResourceImpl(final UserAccessServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public GenericResponse<UserAccessDTO> loadUserAccess(@Valid @RequestBody final CredentialsDTO credentials) {
        return new GenericResponse<>(
                this.service.loadUserAccess(credentials),
                HttpStatus.OK.value(),
                HttpStatus.OK,
                HttpStatus.OK.getReasonPhrase());
    }
}
