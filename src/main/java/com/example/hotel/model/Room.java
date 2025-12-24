package com.example.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    int floor;
    String number; // e.g. 102, 403, but also "President's suite"
    String features;

    protected Room(){}

    public Room(int floor, String number, String features) {
        this.floor = floor;
        this.number = number;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", floor=" + floor +
                ", number='" + number + '\'' +
                ", features='" + features + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    public String getFeatures() {
        return features;
    }
}
