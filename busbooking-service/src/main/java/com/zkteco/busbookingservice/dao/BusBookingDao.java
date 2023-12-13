package com.zkteco.busbookingservice.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bus-booking-table")
public class BusBookingDao {

    @Id
    private String bookingId;
    private Long userId;
    private String busId;
    private int seatNo;
    private Long bookingTime;
    private String bookingStatus;
    private String paymentStatus;
    private String departureDateTime;
    private String arrivalDateTime;
    private Long contactNumber;
    private String origin;
    private String destination;

}
