package com.example.hotel.model;

import jakarta.persistence.*;

import java.time.LocalDate;

// 026-01-08T15:31:58.849+01:00 ERROR 58556 -
// -- [hotel] [           main] j.LocalContainerEntityManagerFactoryBean :
// Failed to initialize JPA EntityManagerFactory:
// Property 'com.example.hotel.model.Booking.user'
// is not a collection and may not be a '@OneToMany', '@ManyToMany', or '@ElementCollection'
//2
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    Room room;  // The simplest case: We can only book one room
    @ManyToOne
    User user;
    LocalDate startDate;
    LocalDate endDate;

    public Booking() {
    }

    public Booking(Room room, User user, LocalDate from, LocalDate to) {
        this.room = room;
        this.user = user;
        this.startDate = from;
        this.endDate = to;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room +
                ", user=" + user +
                ", from=" + startDate +
                ", to=" + endDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
