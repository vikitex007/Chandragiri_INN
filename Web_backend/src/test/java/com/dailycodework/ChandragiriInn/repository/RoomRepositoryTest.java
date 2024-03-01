package com.dailycodework.ChandragiriInn.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataJpaTest
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    @Rollback(value = false)
    public void testFindDistinctRoomTypes() {
        // Act
        List<String> distinctRoomTypes = roomRepository.findDistinctRoomTypes();

        // Assert
        assertNotNull(distinctRoomTypes);
        assertEquals(3, distinctRoomTypes.size()); // Assuming there are 3 distinct room types
    }

    @Test
    @Rollback(value = false)
    public void testFindAvailableRoomsByDatesAndType() {
        // Arrange
        String roomType = "Deluxe"; // Assuming 'Deluxe' is a room type
        // LocalDate startDate, endDate; // Assuming you have start and end dates for availability

        // Act
        List<Room> availableRooms = roomRepository.findAvailableRoomsByDatesAndType(roomType, startDate, endDate);

        // Assert
        assertNotNull(availableRooms);
        // Add more assertions as needed based on your specific criteria
    }
}
