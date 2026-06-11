package com.company.movie_booking_system.theatre.service;


import com.company.movie_booking_system.theatre.dto.TheatreRequestDTO;
import com.company.movie_booking_system.theatre.dto.TheatreResponseDTO;

import java.util.List;

public interface TheatreService {

    TheatreResponseDTO createTheatre(
            TheatreRequestDTO request
    );

    TheatreResponseDTO getTheatreById(
            Long id
    );

    List<TheatreResponseDTO> getAllTheatres();

    TheatreResponseDTO updateTheatre(
            Long id,
            TheatreRequestDTO request
    );

    void deleteTheatre(Long id);
}
