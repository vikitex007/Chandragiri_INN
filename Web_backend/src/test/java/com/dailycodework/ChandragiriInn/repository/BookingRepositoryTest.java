package com.dailycodework.ChandragiriInn.repository;

import com.dailycodework.ChandragiriInn.model.BookedRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookingRepositoryTest {
    @Autowired
    private BookingRepository bookingRepository;
    @Test
    @Rollback(value = false)
    public void findByRoomIdTest() {
        // Given
        Long roomId = 1L;

        // When
        List<BookedRoom> bookedRooms = bookingRepository.findByRoomId(roomId);

        // Then
        assertThat(bookedRooms).isNotNull();
        assertThat(bookedRooms).isNotEmpty();
    }
    @Test
    public void findByBookingConfirmationCodeTest() {
        // Given
        String confirmationCode = "ABC123";
        // When
        Optional<BookedRoom> bookedRoomOptional = bookingRepository.findByBookingConfirmationCode(confirmationCode);
        // Then
        assertThat(bookedRoomOptional).isPresent();
    }
    @Test
    public void findByGuestEmailTest() {
        // Given
        String email = "test@example.com";
        // When
        List<BookedRoom> bookedRooms = bookingRepository.findByGuestEmail(email);
        // Then
        assertThat(bookedRooms).isNotNull();
        assertThat(bookedRooms).isNotEmpty();
    }
}
