package com.company.movie_booking_system.theatre.service;


import com.company.movie_booking_system.exception.BadRequestException;
import com.company.movie_booking_system.exception.ResourceNotFoundException;
import com.company.movie_booking_system.theatre.dto.TheatreRequestDTO;
import com.company.movie_booking_system.theatre.dto.TheatreResponseDTO;
import com.company.movie_booking_system.theatre.entity.Theatre;
import com.company.movie_booking_system.theatre.mapper.TheatreMapper;
import com.company.movie_booking_system.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final TheatreMapper theatreMapper;

    @Override
    public TheatreResponseDTO createTheatre(
            TheatreRequestDTO request
    ) {

        if (theatreRepository.existsByNameAndCity(
                request.getName(),
                request.getCity()
        )) {

            throw new BadRequestException(
                    "Theatre already exists in this city"
            );
        }

        Theatre theatre =
                theatreMapper.toEntity(request);

        Theatre savedTheatre =
                theatreRepository.save(theatre);

        return theatreMapper.toResponse(savedTheatre);
    }

    @Override
    public TheatreResponseDTO getTheatreById(
            Long id
    ) {

        Theatre theatre = theatreRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id: " + id
                        ));

        return theatreMapper.toResponse(theatre);
    }

    @Override
    public List<TheatreResponseDTO> getAllTheatres() {

        return theatreRepository.findAll()
                .stream()
                .map(theatreMapper::toResponse)
                .toList();
    }

    @Override
    public TheatreResponseDTO updateTheatre(
            Long id,
            TheatreRequestDTO request
    ) {

        Theatre theatre = theatreRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id: " + id
                        ));

        theatre.setName(request.getName());
        theatre.setCity(request.getCity());
        theatre.setAddress(request.getAddress());
        theatre.setTotalSeats(request.getTotalSeats());

        Theatre updatedTheatre =
                theatreRepository.save(theatre);

        return theatreMapper.toResponse(updatedTheatre);
    }

    @Override
    public void deleteTheatre(Long id) {

        Theatre theatre = theatreRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id: " + id
                        ));

        theatreRepository.delete(theatre);
    }
}