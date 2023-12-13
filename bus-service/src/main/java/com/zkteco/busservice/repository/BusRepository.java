package com.zkteco.busservice.repository;

import com.zkteco.busservice.dao.BusDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusRepository extends JpaRepository<BusDao,String> {

    BusDao findByOriginAndDestination(String origin, String destination);

    @Query("SELECT b FROM BusDao b WHERE b.origin = :origin AND b.destination = :destination " +
            "AND b.departureDateTime = :departureDateTime ")
    List<BusDao> findByOriginAndDestinationAndDepartureDateTimeAndArrivalDateTime(String origin, String destination, String departureDateTime);
}
