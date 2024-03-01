package com.dailycodework.ChandragiriInn.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @Rollback(value = false)
    public void testExistsByEmail() {
        // Arrange
        String email = "test@example.com"; // Replace with an existing email in your database

        // Act
        boolean exists = userRepository.existsByEmail(email);

        // Assert
        assertTrue(exists); // Assuming the email exists
    }
    @Test
    @Rollback(value = false)
    public void testDeleteByEmail() {
        // Arrange
        String email = "test@example.com"; // Replace with an existing email in your database
        // Act
        userRepository.deleteByEmail(email);
        // Assert
        assertFalse(userRepository.existsByEmail(email)); // Assuming the email is deleted
    }
    @Test
    @Rollback(value = false)
    public void testFindByEmail() {
        // Arrange
        String email = "test@example.com"; // Replace with an existing email in your database
        // Act
        User user = userRepository.findByEmail(email);
        // Assert
        assertNotNull(user); // Assuming the user with the given email exists
        assertEquals(email, user.getEmail());
    }
}
