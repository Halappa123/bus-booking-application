package com.zkteco.busbookingservice.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bus-booking-table")
public class BusBookingDao {

    @Id
    private String bookingId;


    private Long userId;

    private String busId;
    private int seats;
    private Long bookingTime;

    private String status;

}
