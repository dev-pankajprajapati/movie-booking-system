package com.company.movie_booking_system.payment.service;



import com.company.movie_booking_system.booking.entity.Booking;
import com.company.movie_booking_system.booking.repository.BookingRepository;
import com.company.movie_booking_system.constant.PaymentStatus;
import com.company.movie_booking_system.exception.BadRequestException;
import com.company.movie_booking_system.exception.ResourceNotFoundException;
import com.company.movie_booking_system.payment.dto.PaymentRequestDTO;
import com.company.movie_booking_system.payment.dto.PaymentResponseDTO;
import com.company.movie_booking_system.payment.entity.Payment;
import com.company.movie_booking_system.payment.mapper.PaymentMapper;
import com.company.movie_booking_system.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final PaymentMapper paymentMapper;

    @Override
    @Transactional
    public PaymentResponseDTO makePayment(
            PaymentRequestDTO request
    ) {

        Booking booking = bookingRepository.findById(
                        request.getBookingId()
                )
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Booking not found with id: "
                                        + request.getBookingId()
                        ));

        if (paymentRepository.existsByBooking(booking)) {

            throw new BadRequestException(
                    "Payment already exists for this booking"
            );
        }

        Payment payment = Payment.builder()
                .booking(booking)
                .amount(booking.getTotalAmount())
                .status(PaymentStatus.SUCCESS)
                .build();

        Payment savedPayment =
                paymentRepository.save(payment);

        return paymentMapper.toResponse(
                savedPayment
        );
    }

    @Override
    public PaymentResponseDTO getPaymentById(
            Long id
    ) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Payment not found with id: "
                                        + id
                        ));

        return paymentMapper.toResponse(payment);
    }
}