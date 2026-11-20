package ie.atu.sample.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank
    @Size(min = 2, max = 60)
    private String organizerName;
    @Positive
    private int attendeeCount;

    private String status;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}
