package com.ashir.reservations.controller;

import com.ashir.reservations.model.Room;
import com.ashir.reservations.service.RoomService;
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
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room){
        return new ResponseEntity<>(roomService.saveRoom(room), HttpStatus.CREATED);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<Optional<Room>> getRoom(@PathVariable Integer roomNumber){
        return new ResponseEntity<>(roomService.getRoom(roomNumber),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms(){
        return new ResponseEntity<>(roomService.getAllRooms(),HttpStatus.OK);
    }

    @PutMapping("/{roomNumber}")
    private ResponseEntity<Room> updateRoom(@PathVariable Integer roomNumber, @RequestBody Room room){
        return new ResponseEntity<>(roomService.updateRoom(roomNumber, room), HttpStatus.CREATED);
    }

    @DeleteMapping("/{roomNumber}")
    private ResponseEntity<String> deleteRoom(@PathVariable Integer roomNumber){
        roomService.deleteRoom(roomNumber);
        return new ResponseEntity<>("Room deleted", HttpStatus.NO_CONTENT);
    }
}
