package com.product.mapper;

import com.product.domain.UserAccess;
import com.product.dto.UserAccessDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
public class IUserAccessMapperTest {
    @Autowired
    private IUserAccessMapper userAccessMapper;

    @Test
    public void toDTOTest() {
        UserAccess userAccess = new UserAccess()
                .setEmail("user@email.com")
                .setPassword("123");

        UserAccessDTO userAccessDTO = this.userAccessMapper.toDTO(userAccess);
        assertThat(userAccessDTO.getEmail()).isEqualTo(userAccess.getEmail());
    }

    @Test
    public void toDomainTest() {
        UserAccessDTO userAccessDTO = new UserAccessDTO()
                .setEmail("user@email.com")
                .setPassword("123");

        UserAccess userAccess = this.userAccessMapper.toDomain(userAccessDTO);
        assertThat(userAccessDTO.getEmail()).isEqualTo(userAccess.getEmail());
    }

    @Test
    public void toPageDTOTest() {
        List<UserAccess> userAccesses = Collections.singletonList(
                new UserAccess()
                        .setEmail("user@email.com")
                        .setPassword("123"));

        List<UserAccessDTO> userAccessDTOS = this.userAccessMapper.toPageDTO(userAccesses);
        assertThat(userAccessDTOS.size()).isGreaterThanOrEqualTo(1);
    }
}
