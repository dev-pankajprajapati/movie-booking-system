package com.company.movie_booking_system.theatre.controller;


import com.company.movie_booking_system.theatre.dto.TheatreRequestDTO;
import com.company.movie_booking_system.theatre.dto.TheatreResponseDTO;
import com.company.movie_booking_system.theatre.service.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TheatreResponseDTO> createTheatre(
            @Valid @RequestBody TheatreRequestDTO request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(theatreService.createTheatre(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<TheatreResponseDTO> getTheatreById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                theatreService.getTheatreById(id)
        );
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<TheatreResponseDTO>> getAllTheatres() {

        return ResponseEntity.ok(
                theatreService.getAllTheatres()
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TheatreResponseDTO> updateTheatre(
            @PathVariable Long id,
            @Valid @RequestBody TheatreRequestDTO request
    ) {

        return ResponseEntity.ok(
                theatreService.updateTheatre(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTheatre(
            @PathVariable Long id
    ) {

        theatreService.deleteTheatre(id);

        return ResponseEntity.noContent().build();
    }
}
