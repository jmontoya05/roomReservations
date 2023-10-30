package com.ashir.reservations.service;

import com.ashir.reservations.model.Room;
import com.ashir.reservations.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }

    public Optional<Room> getRoom(Integer roomNumber){
        return roomRepository.findById(roomNumber);
    }

    public List<Room> getAllRooms(){
        return (List<Room>) roomRepository.findAll();
    }

    public Room updateRoom(Integer roomNumber, Room room){
        Room roomToUpdate = getRoom(roomNumber).orElse(null);

        if (roomToUpdate != null){
            roomToUpdate.setBasePrice(room.getBasePrice());
            roomToUpdate.setRoomTypeId(room.getRoomTypeId());
            return roomRepository.save(roomToUpdate);
        }
        throw new RuntimeException();
    }

    public void deleteRoom(Integer roomNumber){
        Room room = roomRepository.findById(roomNumber).orElse(null);

        if (room != null){
            roomRepository.deleteById(roomNumber);
            return;
        }
        throw new RuntimeException();
    }
}
