package com.product.resource;

import com.product.abstracts.AbstractResource;
import com.product.dto.UserAccessDTO;
import com.product.service.UserAccessServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/user-accesses")
@Api(value = "User Access", tags = "User Access")
public class UserAccessResourceImpl extends AbstractResource<UserAccessDTO, String> {
    @Autowired
    public UserAccessResourceImpl(final UserAccessServiceImpl service) {
        super(service);
    }
}
