package com.zkteco.busbookingservice.controller;

import com.zkteco.busbookingservice.service.BusBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking-api")
public class BusBookingController {

    @Autowired
    private BusBookingService busBookingService;
}
