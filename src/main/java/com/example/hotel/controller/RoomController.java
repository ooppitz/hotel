package com.example.hotel.controller;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    String getRoom(@PathVariable("id") String roomId, Model model){

        Room room532 = service.findByNumber(roomId);
        model.addAttribute("room", room532);
        return "room";
    }

    @GetMapping("/all")
    String getAll(Model model){
        List<Room> allRooms = service.getRooms();
        model.addAttribute("rooms", allRooms);
        return "room-list";
    }

    @GetMapping("/edit/{id}")
    String editRoom(@PathVariable("id") String roomNumber, Model model){

        Room room532 = service.findByNumber(roomNumber);
        model.addAttribute("room", room532);
        return "room-edit";
    }

    @PostMapping("/update/{number}")
    public String updateRoom(@PathVariable("number") String number, @RequestParam("features") String features) {
        Room room = service.findByNumber(number);
        service.updateRoom(room.getId(), features);
        return "redirect:/rooms/all"; // List all rooms with update data
    }

}
