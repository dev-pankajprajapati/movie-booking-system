package com.company.movie_booking_system.show.service;



import com.company.movie_booking_system.show.dto.ShowRequestDTO;
import com.company.movie_booking_system.show.dto.ShowResponseDTO;

import java.util.List;

public interface ShowService {

    ShowResponseDTO createShow(
            ShowRequestDTO request
    );

    ShowResponseDTO getShowById(
            Long id
    );

    List<ShowResponseDTO> getAllShows();

    ShowResponseDTO updateShow(
            Long id,
            ShowRequestDTO request
    );

    void deleteShow(Long id);
}
