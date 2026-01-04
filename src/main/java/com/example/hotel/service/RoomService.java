package com.example.hotel.service;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room findByNumber(String roomNumber) {
        return repository.findByNumber(roomNumber);
    }

    public List<Room> getRooms(){
        return repository.findAll();
    }

    public Room updateRoom(Long id, String features){
        Room room = repository.findById(id).orElseThrow( () -> new RuntimeException("Room not found"));
        room.setFeatures(features);
        return repository.save(room);
    }
}


