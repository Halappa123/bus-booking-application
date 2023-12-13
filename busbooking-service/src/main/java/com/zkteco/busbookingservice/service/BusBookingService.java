package com.zkteco.busbookingservice.service;

import com.zkteco.busbookingservice.dao.BusBookingDao;
import com.zkteco.busbookingservice.dto.BusService;

public interface BusBookingService {
    BusBookingDao saveBusByOriginAndDestination(String origin, String destination, String departureDateTime, int seatNo);
}
