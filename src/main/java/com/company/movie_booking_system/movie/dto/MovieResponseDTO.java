package com.company.movie_booking_system.movie.dto;



import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MovieResponseDTO {

    private Long id;

    private String title;

    private String description;

    private Integer duration;

    private String language;

    private String genre;

    private LocalDate releaseDate;

    private String posterUrl;
}
