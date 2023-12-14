package com.zkteco.busbookingservice.repository;

import com.zkteco.busbookingservice.dao.BusBookingDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BusBookingRepository extends JpaRepository<BusBookingDao,String> {
//    BusBookingDao findByOriginAndDestinationAndDepartureDateTimeAndSeats(String origin, String destination, String departureDateTime, long seats);

//    @Query("SELECT b FROM BusDao b WHERE b.origin = :origin AND b.destination = :destination " +
//            "AND b.departureDateTime = :departureDateTime And b.seats = :seats ")
//    BusBookingDao findByOriginAndDestinationAndDepartureDateTimeAndSeats(String origin, String destination, String departureDateTime, long seats);
//    BusBookingDao findByOriginAndDestinationAndDepartureDateTimeAndSeatNo(String origin, String destination, String departureDateTime,long seats);
}
