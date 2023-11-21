package com.zkteco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusService {

    private String busId;
    private String busNumber;
    private Long capacity;
    private Long availableSeats;
    private String model;
    private String type;
    private String operator;
    private String route;
    private String departureDateTime;
    private String arrivalDateTime;
    private Long contactNumber;
    private String origin;
    private String destination;
}
