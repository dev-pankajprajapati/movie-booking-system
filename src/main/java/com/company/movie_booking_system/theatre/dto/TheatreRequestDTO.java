package com.company.movie_booking_system.theatre.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheatreRequestDTO {

    @NotBlank(message = "Theatre name is required")
    @Size(max = 150, message = "Theatre name cannot exceed 150 characters")
    private String name;

    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City cannot exceed 100 characters")
    private String city;

    @NotBlank(message = "Address is required")
    @Size(max = 300, message = "Address cannot exceed 300 characters")
    private String address;

    @NotNull(message = "Total seats is required")
    @Positive(message = "Total seats must be greater than 0")
    private Integer totalSeats;
}