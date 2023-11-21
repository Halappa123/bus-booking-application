package com.zkteco.busbookingservice.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(value = "bus_booking_dao")
public class BusBookDao {

    private String bookingId;
    private Long userId;
    private String busId;
    private Long seatNumber;


}
