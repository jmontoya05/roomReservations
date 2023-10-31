package com.ashir.reservations.repository;

import com.ashir.reservations.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String> {
}
