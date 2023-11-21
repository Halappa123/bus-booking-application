package com.zkteco.busservice.serviceimpl;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;
import com.zkteco.busservice.dto.ResultEntity;
import com.zkteco.busservice.repository.BusRepository;
import com.zkteco.busservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

   // private static final Logger logger = LoggerFactory.getLogger(BusServiceImpl.class);


    @Autowired
    private BusRepository busRepository;

    @Override
    public BusDao saveAllBusDetails(BusDto busDto) {
        BusDao busDao=new BusDao();
        busDao.setBusNumber(busDto.getBusNumber());
        busDao.setCapacity(busDto.getCapacity());
        busDao.setModel(busDto.getModel());
        busDao.setType(busDto.getType());
        busDao.setRoute(busDto.getRoute());
        busDao.setAvailableSeats(busDto.getAvailableSeats());
        busDao.setOperator(busDto.getOperator());
        busDao.setDepartureDateTime(busDto.getDepartureDateTime());
        busDao.setArrivalDateTime(busDto.getArrivalDateTime());
        busDao.setContactNumber(busDto.getContactNumber());
        busDao.setOrigin(busDto.getOrigin());
        busDao.setDestination(busDto.getDestination());
        busRepository.save(busDao);
        System.out.println(" All Bus Details Are saved successfully " +busDao);
        return busDao;
    }

    public List<BusDao> getAllBusDetails() {
         List<BusDao> daoList=busRepository.findAll();
       // logger.info("All bus details fetched successfully. Total {} buses found.", daoList.size());
        System.out.println("All bus details fetched successfully. total {} busses found "+daoList.size());

        return daoList;
    }
}
