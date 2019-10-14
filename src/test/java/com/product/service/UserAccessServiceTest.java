package com.product.service;

import com.product.domain.UserAccess;
import com.product.repository.IUserAccessRepository;
import com.product.security.property.JwtConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=test")
public class UserAccessServiceTest {
    @Autowired
    private IUserAccessRepository userAccessRepository;
    @Autowired
    private JwtConfiguration jwtConfiguration;
    private String userAccessId;

    @Before
    public void prepareDataBaseToTests() {
        this.userAccessRepository.deleteAll();

        for(int i = 1; i <= 5; i++) {
            UserAccess userAccess = new UserAccess()
                    .setEmail("user00" + i + "@email.com")
                    .setPassword("123");
            UserAccess userAccessSaved = this.userAccessRepository.save(userAccess);

            this.userAccessId = userAccessSaved.getId();
        }
    }

    @Test
    public void saveOrUpdateTest() {
        UserAccess userAccess = new UserAccess()
                .setEmail("user_save@email.com")
                .setPassword("123");
        UserAccess userAccessSaved = this.userAccessRepository.save(userAccess);

        assertThat(userAccessSaved.getEmail()).isEqualTo(userAccess.getEmail());
    }

    @Test
    public void loadAccessTest() {
        String token = this.jwtConfiguration.generateToken("user1@email.com");
        Assert.assertTrue(token.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$"));
    }

    @Test
    public void successfulAuthentication() {
        String token = this.jwtConfiguration.generateToken("user1@email.com");
        Assert.assertTrue(token.matches("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$"));
    }

    @Test
    public void saveOrUpdateTest2() {
        UserAccess userAccess = new UserAccess()
                .setEmail("user_to_update@email.com")
                .setPassword("123");
        UserAccess userAccessToUpdate = this.userAccessRepository.save(userAccess);

        userAccessToUpdate.setEmail("user_updated@email.com");
        UserAccess userAccessUpdated = this.userAccessRepository.save(userAccessToUpdate);
        assertThat(userAccessUpdated.getEmail()).isEqualTo("user_updated@email.com");
    }

    @Test
    public void findAllTest() {
        List<UserAccess> userAccesses = this.userAccessRepository.findAll();
        assertThat(userAccesses.size()).isGreaterThanOrEqualTo(5);
    }

    @Test
    public void findByIdTest() {
        Optional<UserAccess> userAccessOpt = this.userAccessRepository.findById(this.userAccessId);
        assertThat(userAccessOpt).isPresent();
    }

    @Test
    public void deleteTest() {
        Optional<UserAccess> userAccessOpt = this.userAccessRepository.findById(this.userAccessId);
        assertThat(userAccessOpt).isPresent();

        userAccessOpt.ifPresent(this.userAccessRepository::delete);

        Optional<UserAccess> userAccessOptAfterDelete = this.userAccessRepository.findById(this.userAccessId);
        assertThat(userAccessOptAfterDelete).isNotPresent();
    }

}
