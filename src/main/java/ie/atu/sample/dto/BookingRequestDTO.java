package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookingRequestDTO(
    @NotBlank
    @Size(min = 2, max = 60)
    String organizerName,

    @Positive
    int attendeeCount,

    @Positive
    Long roomId
)
{}
