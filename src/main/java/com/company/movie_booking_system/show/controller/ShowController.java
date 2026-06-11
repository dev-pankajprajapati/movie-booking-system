package com.company.movie_booking_system.show.controller;


import com.company.movie_booking_system.show.dto.ShowRequestDTO;
import com.company.movie_booking_system.show.dto.ShowResponseDTO;
import com.company.movie_booking_system.show.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShowResponseDTO> createShow(
            @Valid @RequestBody ShowRequestDTO request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(showService.createShow(request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<ShowResponseDTO> getShowById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                showService.getShowById(id)
        );
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<ShowResponseDTO>> getAllShows() {

        return ResponseEntity.ok(
                showService.getAllShows()
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ShowResponseDTO> updateShow(
            @PathVariable Long id,
            @Valid @RequestBody ShowRequestDTO request
    ) {

        return ResponseEntity.ok(
                showService.updateShow(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteShow(
            @PathVariable Long id
    ) {

        showService.deleteShow(id);

        return ResponseEntity.noContent().build();
    }
}
