package com.example.hotel;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.model.User;
import com.example.hotel.repository.BookingRepository;
import com.example.hotel.repository.RoomRepository;
import com.example.hotel.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HotelApplication {

    private static final Logger logger = LoggerFactory.getLogger(HotelApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

    @Bean
    public CommandLineRunner createBookings(UserRepository userRepo, RoomRepository roomRepo, BookingRepository bookingRepo) {
        return (args) -> {

            User user = new User("Ferdinand Sauerbruch", "ferdinand@sauerbruch.de");
            Room room1 = new Room(9, "907", "TV, Einzelzimmer, Meerblick");
            Room room2 = new Room(9, "908", "TV, Doppelzimmer, Meerblick");

            Booking booking1 = new Booking(room1, user,
                    LocalDate.of(2026,1,2),
                    LocalDate.of(2026,1,5));

            Booking booking2 = new Booking(room2, user,
                    LocalDate.of(2026,3,2),
                    LocalDate.of(2026,3,5));

            roomRepo.save(room1);
            roomRepo.save(room2);
            userRepo.save(user);
            bookingRepo.save(booking1);
            bookingRepo.save(booking2);


            // fetch all customers
            logger.info("Bookings found with findAll():");
            logger.info("-------------------------------");
            bookingRepo.findAll().forEach(b -> {
                logger.info(b.toString());
            });
            logger.info("");

        };
    }

    @Bean
    public CommandLineRunner createUsers(UserRepository repository) {
        return (args) -> {
            // save a few rooms
            repository.save(new User("Albert Einstein", "einstein@eth.ch"));
            repository.save(new User("Niels Bohr", "niels@bohr.dk"));

            // fetch all customers
            logger.info("Rooms found with findAll():");
            logger.info("-------------------------------");
            repository.findAll().forEach(user -> {
                logger.info(user.toString());
            });
            logger.info("");

        };
    }

    @Bean
    public CommandLineRunner demo(RoomRepository repository) {
        return (args) -> {
            // save a few rooms
            repository.save(new Room(1,"102", "TV"));
            repository.save(new Room(4, "403", "TV, PS5"));
            repository.save(new Room(5, "532", "TV, Minibar"));
            repository.save(new Room(5, "534", "TV, Minibar"));
            repository.save(new Room(5, "540", "TV, Minibar"));
            repository.save(new Room(6, "President's suite", "TV, Jacuzzi"));

            // fetch all customers
            logger.info("Rooms found with findAll():");
            logger.info("-------------------------------");
            repository.findAll().forEach(room -> {
                logger.info(room.toString());
            });
            logger.info("");

            // fetch an individual customer by ID
            Room room = repository.findById(1L);
            logger.info("Room found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(room.toString());
            logger.info("");

            // fetch customers by last name
            logger.info("Room found with findByFloor(5):");
            logger.info("--------------------------------------------");
            repository.findByFloor(5).forEach(roomOn5 -> {
                logger.info(roomOn5.toString());
            });

            logger.info("Room found with findByNumber('532'):");
            logger.info("--------------------------------------------");
            Room room532 = repository.findByNumber("532");
            logger.info(room532.toString());

            logger.info("");
        };
    }
}
