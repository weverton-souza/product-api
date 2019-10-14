package com.product.repository;

import com.product.domain.UserAccess;
import com.product.interfaces.IRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserAccessRepository extends IRepository<UserAccess, String> {
    Optional<UserAccess> findByEmail(String email);
}
