package com.zkteco.busservice.dao;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Data
@Entity
@Table(name = "bus_table")
public class BusDao {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String busId;

    @Column(name = "Bus_Number",nullable = false)
    private String busNumber;

    @Column(name = "Capacity",nullable = false)
    private Long capacity;

    @Column(name = "Available_seats",nullable = false)
    private Long availableSeats;

    @Column(name = "Model",nullable = false)
    private String model;

    @Column(name = "Type",nullable = false)
    private String type;

    @Column(name = "Bus_Operator",nullable = false)
    private String operator;

    @Column(name = "Bus_Route",nullable = false)
    private String route;

    @Column(name = "Departure_Time",nullable = false)
    private String departureDateTime;

    @Column(name = "Arrival_Time",nullable = false)
    private String arrivalDateTime;

    @Column(name = "Contact_Number",nullable = false)
    private Long contactNumber;

    @Column(name = "Bus_Origin",nullable = false)
    private String origin;

    @Column(name = "Bus_Destination",nullable = false)
    private String destination;

    @Column(name="Bus_Fair",nullable = false)
    private int fair;


}
