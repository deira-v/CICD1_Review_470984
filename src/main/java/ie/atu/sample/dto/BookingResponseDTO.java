package ie.atu.sample.dto;

import lombok.Data;

@Data
public class BookingResponseDTO {
    private Long id;

    private String organizerName;
    private int attendeeCount;
    private Long roomId;
    private String roomName;
    private String status;
}
