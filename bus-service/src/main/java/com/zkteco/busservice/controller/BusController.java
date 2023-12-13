package com.zkteco.busservice.controller;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;
import com.zkteco.busservice.dto.ResultEntity;
import com.zkteco.busservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus-api")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/save_all_bus_details")
    public ResponseEntity<BusDao> saveBusDetails(@RequestBody BusDto busDto){
        return new ResponseEntity<BusDao>(busService.saveAllBusDetails(busDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_all_bus_details")
    public ResponseEntity<List<BusDao>> getAllBusDetails(){
        return new ResponseEntity<List<BusDao>>(busService.getAllBusDetails(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_all_bus_details_list")
    public ResponseEntity<ResultEntity> getAllBusDetails1(){
        return new ResponseEntity<ResultEntity>(busService.getAllBusDetailsList(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_bus/{origin}/{destination}")
    public ResponseEntity<ResultEntity> getBusByOriginAndDestination(@PathVariable String origin,@PathVariable String destination){
        return new ResponseEntity<ResultEntity>(busService.getBusByOriginAndDestination(origin,destination),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{busId}")
    public ResponseEntity<ResultEntity> deleteBusDetailsById(@PathVariable String busId){
        return new ResponseEntity<ResultEntity>(busService.deleteById(busId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete_all")
    public ResponseEntity<ResultEntity> deleteAllBusDetails(){
        return new ResponseEntity<ResultEntity>(busService.deleteAllDetails(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/book_bus/{origin}/{destination}/{departureDateTime}")
    public ResponseEntity<List<BusDao>> getBusDetails(@PathVariable String origin,@PathVariable String destination,@PathVariable String departureDateTime){
        return new ResponseEntity<List<BusDao>>(busService.getBusDetailsByOriginDestinationAndDepartureDateTime(origin,destination,departureDateTime),HttpStatus.ACCEPTED);
    }


}
