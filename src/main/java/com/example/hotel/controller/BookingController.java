package com.example.hotel.controller;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.service.BookingService;
import com.example.hotel.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    String getRoom(@PathVariable("id") Long id, Model context){
        Optional<Booking> booking = service.findById(id);
        context.addAttribute("booking", booking);
        return "room";
    }

    @GetMapping("/all")
    String getAll(Model model){
        List<Booking> allRooms = service.getBookings();
        model.addAttribute("bookings", allRooms);
        return "booking-list";
    }

}

