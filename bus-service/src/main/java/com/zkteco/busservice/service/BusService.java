package com.zkteco.busservice.service;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;

import java.util.List;

public interface BusService {
    BusDao saveAllBusDetails(BusDto busDto);

    List<BusDao> getAllBusDetails();
}
