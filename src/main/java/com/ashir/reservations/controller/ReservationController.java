package com.ashir.reservations.controller;

import com.ashir.reservations.dto.ReservationRequest;
import com.ashir.reservations.dto.ReservationResponse;
import com.ashir.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody ReservationRequest reservationRequest){
        return new ResponseEntity<>(reservationService.saveReservation(reservationRequest), HttpStatus.CREATED);
    }
}
