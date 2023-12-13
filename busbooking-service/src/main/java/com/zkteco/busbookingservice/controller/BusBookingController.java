package com.zkteco.busbookingservice.controller;

import com.zkteco.busbookingservice.dao.BusBookingDao;
import com.zkteco.busbookingservice.service.BusBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking-api")
public class BusBookingController {

    @Autowired
    private BusBookingService busBookingService;


    @PostMapping("/book_buss/{origin}/{destination}/{departureDateTime}/{seatNo}")
    public ResponseEntity<BusBookingDao> bookBus(@PathVariable String origin,@PathVariable String destination,
                                                 @PathVariable String departureDateTime,@PathVariable int seatNo
                                                 ){
        return new ResponseEntity<BusBookingDao>(busBookingService.saveBusByOriginAndDestination(origin,destination,departureDateTime,seatNo), HttpStatus.ACCEPTED);

    }


}
