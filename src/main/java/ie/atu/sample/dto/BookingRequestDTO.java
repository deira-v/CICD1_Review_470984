package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookingRequestDTO {
    @NotBlank
    @Size(min = 2, max = 60)
    private String organizerName;

    @Positive
    private int attendeeCount;

    @Positive
    private Long roomId;
}
