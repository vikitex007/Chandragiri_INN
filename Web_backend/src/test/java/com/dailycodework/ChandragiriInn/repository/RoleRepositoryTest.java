package com.dailycodework.ChandragiriInn.repository;

import com.dailycodework.ChandragiriInn.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;
    @Test
    public void findByNameTest() {
        // Given
        String roleName = "ROLE_USER";

        // When
        Optional<Role> roleOptional = roleRepository.findByName(roleName);

        // Then
        assertThat(roleOptional).isPresent();
    }
    @Test
    public void existsByNameTest() {
        // Given
        String roleName = "ROLE_ADMIN";

        // When
        boolean exists = roleRepository.existsByName(roleName);

        // Then
        assertThat(exists).isTrue();
    }
}
