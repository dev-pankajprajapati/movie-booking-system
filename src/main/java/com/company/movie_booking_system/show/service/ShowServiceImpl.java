package com.company.movie_booking_system.show.service;



import com.company.movie_booking_system.exception.ResourceNotFoundException;
import com.company.movie_booking_system.movie.entity.Movie;
import com.company.movie_booking_system.movie.repository.MovieRepository;
import com.company.movie_booking_system.show.dto.ShowRequestDTO;
import com.company.movie_booking_system.show.dto.ShowResponseDTO;
import com.company.movie_booking_system.show.entity.Show;
import com.company.movie_booking_system.show.mapper.ShowMapper;
import com.company.movie_booking_system.show.repository.ShowRepository;
import com.company.movie_booking_system.theatre.entity.Theatre;
import com.company.movie_booking_system.theatre.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowMapper showMapper;

    @Override
    public ShowResponseDTO createShow(
            ShowRequestDTO request
    ) {

        Movie movie = movieRepository.findById(
                        request.getMovieId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: "
                                        + request.getMovieId()
                        ));

        Theatre theatre = theatreRepository.findById(
                        request.getTheatreId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id: "
                                        + request.getTheatreId()
                        ));

        Show show = Show.builder()
                .movie(movie)
                .theatre(theatre)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .ticketPrice(request.getTicketPrice())
                .availableSeats(theatre.getTotalSeats())
                .build();

        Show savedShow =
                showRepository.save(show);

        return showMapper.toResponse(savedShow);
    }

    @Override
    public ShowResponseDTO getShowById(
            Long id
    ) {

        Show show = showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));

        return showMapper.toResponse(show);
    }

    @Override
    public List<ShowResponseDTO> getAllShows() {

        return showRepository.findAll()
                .stream()
                .map(showMapper::toResponse)
                .toList();
    }

    @Override
    public ShowResponseDTO updateShow(
            Long id,
            ShowRequestDTO request
    ) {

        Show show = showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));

        Movie movie = movieRepository.findById(
                        request.getMovieId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id: "
                                        + request.getMovieId()
                        ));

        Theatre theatre = theatreRepository.findById(
                        request.getTheatreId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id: "
                                        + request.getTheatreId()
                        ));

        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setStartTime(request.getStartTime());
        show.setEndTime(request.getEndTime());
        show.setTicketPrice(request.getTicketPrice());

        Show updatedShow =
                showRepository.save(show);

        return showMapper.toResponse(updatedShow);
    }

    @Override
    public void deleteShow(
            Long id
    ) {

        Show show = showRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Show not found with id: " + id
                        ));

        showRepository.delete(show);
    }
}
