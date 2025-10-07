package com.example.users.repo;

import com.example.users.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Test
    void saveAndFindById() {
        var user = new User();
        user.setFullName("Jane Doe");
        user.setEmail("jane@example.com");

        var saved = repo.save(user);

        assertThat(saved.getId()).isNotNull();
        var found = repo.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getEmail()).isEqualTo("jane@example.com");
    }
}