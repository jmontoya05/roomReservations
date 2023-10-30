package com.ashir.reservations.service;

import com.ashir.reservations.model.RoomType;
import com.ashir.reservations.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;
    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public RoomType saveRoomType(RoomType roomType){
        return roomTypeRepository.save(roomType);
    }

    public Optional<RoomType> getRoomType(Integer roomTypeId){
        return roomTypeRepository.findById(roomTypeId);
    }

    public List<RoomType> getAllRoomTypes(){
        return (List<RoomType>) roomTypeRepository.findAll();
    }

    public RoomType updateRoomType(Integer roomTypeId, RoomType roomType){
        RoomType roomTypeToUpdate = getRoomType(roomTypeId).orElse(null);

        if (roomTypeToUpdate != null){
            roomTypeToUpdate.setRoomType(roomType.getRoomType());
            return roomTypeRepository.save(roomTypeToUpdate);
        }
        throw new RuntimeException();
    }

    public void deleteRoomType(Integer roomTypeId){
        RoomType roomType = roomTypeRepository.findById(roomTypeId).orElse(null);

        if (roomType != null){
            roomTypeRepository.deleteById(roomTypeId);
            return;
        }
        throw new RuntimeException();
    }
}
