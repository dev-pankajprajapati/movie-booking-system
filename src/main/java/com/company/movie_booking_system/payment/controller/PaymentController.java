package com.company.movie_booking_system.payment.controller;


import com.company.movie_booking_system.payment.dto.PaymentRequestDTO;
import com.company.movie_booking_system.payment.dto.PaymentResponseDTO;
import com.company.movie_booking_system.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PaymentResponseDTO> makePayment(
            @Valid @RequestBody PaymentRequestDTO request
    ) {

        return ResponseEntity.ok(
                paymentService.makePayment(request)
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                paymentService.getPaymentById(id)
        );
    }
}