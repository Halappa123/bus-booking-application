package com.zkteco.busservice.service;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;
import com.zkteco.busservice.dto.ResultEntity;

import java.util.List;

public interface BusService {
    BusDao saveAllBusDetails(BusDto busDto);

    List<BusDao> getAllBusDetails();

    ResultEntity getAllBusDetailsList();
}
