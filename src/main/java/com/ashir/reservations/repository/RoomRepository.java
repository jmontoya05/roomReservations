package com.ashir.reservations.repository;

import com.ashir.reservations.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
