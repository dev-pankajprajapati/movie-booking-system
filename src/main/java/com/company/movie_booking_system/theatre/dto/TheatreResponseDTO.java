package com.company.movie_booking_system.theatre.dto;



import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TheatreResponseDTO {

    private Long id;

    private String name;

    private String city;

    private String address;

    private Integer totalSeats;
}
