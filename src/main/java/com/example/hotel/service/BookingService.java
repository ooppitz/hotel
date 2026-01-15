package com.example.hotel.service;

import com.example.hotel.model.Booking;
import com.example.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public Optional<Booking> findById(Long id) {
        return repository.findById(id);
    }

    public List<Booking> getBookings() {
        return repository.findAll();
    }

    public List<Booking> findBookingsInRange(LocalDate startDate, LocalDate endDate) {
        return repository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
    }

}


