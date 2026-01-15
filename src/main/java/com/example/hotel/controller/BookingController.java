package com.example.hotel.controller;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.service.BookingService;
import com.example.hotel.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    String getRoom(@PathVariable("id") Long id, Model context) {
        Optional<Booking> booking = service.findById(id);
        context.addAttribute("booking", booking);
        return "room";
    }

    @GetMapping("/all")
    String getAll(Model model) {
        List<Booking> allBookings = service.getBookings();
        model.addAttribute("bookings", allBookings);

        LocalDate startDate = LocalDate.of(2026, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 1, 31);
        List<Booking> bookingsInMonth = service.findBookingsInRange( startDate, endDate);
        model.addAttribute("bookingsInMonth", bookingsInMonth);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "booking-list";
    }


}

