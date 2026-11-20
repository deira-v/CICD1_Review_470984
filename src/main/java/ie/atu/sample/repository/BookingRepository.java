package ie.atu.sample.repository;

import ie.atu.sample.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JPQL Query
public interface BookingRepository
        extends JpaRepository<Booking, Long> {
    Long roomId(Long roomId);

    @Query("""
    SELECT b FROM Booking b
    JOIN b.room r
    WHERE r.name = :roomName
    ORDER BY b.attendeeCount DESC 
""")
    List<Booking> findBookingsByRoomName(@Param("roomName") String roomName);
}
