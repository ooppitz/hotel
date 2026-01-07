package com.example.hotel.repository;

import java.util.List;
import com.example.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    public Room findByNumber(String number);

    List<Room> findByFloor(int floor);

    Room findById(long id);

}
