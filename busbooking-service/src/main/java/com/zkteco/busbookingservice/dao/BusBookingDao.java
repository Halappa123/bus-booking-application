package com.zkteco.busbookingservice.dao;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bus-booking-table")
public class BusBookingDao {

    private String bookingId;
    private Long userId;

    private String busId;
}
