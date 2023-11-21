package com.zkteco.busbookingservice.repository;

import com.zkteco.busbookingservice.dao.BusBookDao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusBookingRepository extends MongoRepository<BusBookDao ,String>{
}
