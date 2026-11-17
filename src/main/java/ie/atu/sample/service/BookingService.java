package ie.atu.sample.service;

import ie.atu.sample.dto.BookingRequestDTO;
import ie.atu.sample.dto.BookingResponseDTO;
import ie.atu.sample.model.Booking;
import ie.atu.sample.model.Room;
import ie.atu.sample.repository.BookingRepository;
import ie.atu.sample.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository repository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository repository,
                          RoomRepository roomRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
    }

    public List<Booking> getBookings() {
        return repository.findAll();
    }

    public BookingResponseDTO reserveRoom(BookingRequestDTO request) {

        //find the room from requestDTO
        Room room = roomRepository.findById(request.roomId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Room not found."
                ));

        // Check that the number of attendees doesn't exceed room capacity
        if(request.attendeeCount() > room.getCapacity()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Number of attendee exceeds room capacity"
            );
        }

        //create new booking object
        Booking booking = new Booking();

        //Set booking details
        booking.setOrganizerName(request.organizerName());
        booking.setAttendeeCount(request.attendeeCount());
        booking.setRoom(room);
        booking.setStatus("ACTIVE");

        //save the booking and pass it to responseDTO
        Booking savedBooking = repository.save(booking);

        BookingResponseDTO response = new BookingResponseDTO();

        response.setId(savedBooking.getId());
        response.setOrganizerName(savedBooking.getOrganizerName());
        response.setAttendeeCount(savedBooking.getAttendeeCount());
        response.setRoomId(room.getId());
        response.setRoomName(room.getName());
        response.setStatus(savedBooking.getStatus());

        return response;

    }


    public Booking getBookingById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Booking not found"
                ));
    }

}
