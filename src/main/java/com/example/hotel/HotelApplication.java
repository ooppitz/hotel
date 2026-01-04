package com.example.hotel;

import com.example.hotel.model.Room;
import com.example.hotel.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApplication {

    private static final Logger logger = LoggerFactory.getLogger(HotelApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
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
