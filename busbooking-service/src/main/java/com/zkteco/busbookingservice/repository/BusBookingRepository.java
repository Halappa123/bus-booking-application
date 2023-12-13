package com.zkteco.busbookingservice.repository;

import com.zkteco.busbookingservice.dao.BusBookingDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusBookingRepository extends MongoRepository<BusBookingDao,String> {
    BusBookingDao findByOriginAndDestinationAndDepartureDateTimeAndSeatNo(String origin, String destination, String departureDateTime,int seatNo);
}
