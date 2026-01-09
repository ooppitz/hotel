package com.example.hotel.repository;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findByUser(User user);

    public List<Booking> findByRoom(Room room);

    public Booking findById(long id);

    List<Booking> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);


}
