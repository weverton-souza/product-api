package com.product.mapper;

import com.product.interfaces.IDomainMapper;
import com.product.domain.UserAccess;
import com.product.dto.UserAccessDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface IUserAccessMapper extends IDomainMapper<UserAccess, UserAccessDTO> {
    @Override
    UserAccessDTO toDTO(final UserAccess domain);
    @Override
    UserAccess toDomain(final UserAccessDTO dto);
    @Override
    List<UserAccessDTO> toPageDTO(final List<UserAccess> items);
}