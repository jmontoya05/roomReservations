package com.ashir.reservations.controller;

import com.ashir.reservations.model.RoomType;
import com.ashir.reservations.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room-types")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping
    public ResponseEntity<RoomType> saveRoomType(@RequestBody RoomType roomType){
        return new ResponseEntity<>(roomTypeService.saveRoomType(roomType), HttpStatus.CREATED);
    }

    @GetMapping("/{roomTypeId}")
    public ResponseEntity<Optional<RoomType>> getRoomType(@PathVariable Integer roomTypeId){
        return new ResponseEntity<>(roomTypeService.getRoomType(roomTypeId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoomType>> getAllRoomTypes(){
        return new ResponseEntity<>(roomTypeService.getAllRoomTypes(),HttpStatus.OK);
    }

    @PutMapping("/{roomTypeId}")
    private ResponseEntity<RoomType> updateRoomType(@PathVariable Integer roomTypeId, @RequestBody RoomType roomType){
        return new ResponseEntity<>(roomTypeService.updateRoomType(roomTypeId, roomType), HttpStatus.CREATED);
    }

    @DeleteMapping("/{roomTypeId}")
    private ResponseEntity<String> deleteRoomType(@PathVariable Integer roomTypeId){
        roomTypeService.deleteRoomType(roomTypeId);
        return new ResponseEntity<>("Room Type deleted", HttpStatus.NO_CONTENT);
    }
}
