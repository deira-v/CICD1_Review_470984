package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingRequestDTO;
import ie.atu.sample.dto.BookingResponseDTO;
import ie.atu.sample.model.Booking;
import ie.atu.sample.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    //Inject Booking service
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Validate incoming requests from BookingResponseDTO
    public BookingResponseDTO reserveRoom(@Valid @RequestBody BookingRequestDTO request){
        return service.reserveRoom(request);
    }

    //Calls the method in booking service
    //retrieve individual bookings
    @GetMapping("/{id}")
    public BookingResponseDTO getBookingById(@PathVariable Long id){
        //return BookingResponseDTO instead of exposing JPA entities
        return service.getBookingById(id);
    }


    @GetMapping("/search")
    public List<BookingResponseDTO> searchBookings(
            @RequestParam String roomName) {

        return service.searchBookings(roomName);
    }

}
