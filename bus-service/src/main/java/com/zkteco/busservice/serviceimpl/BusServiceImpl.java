package com.zkteco.busservice.serviceimpl;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;
import com.zkteco.busservice.dto.ResultEntity;
import com.zkteco.busservice.repository.BusRepository;
import com.zkteco.busservice.service.BusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

   // private static final Logger logger = LoggerFactory.getLogger(BusServiceImpl.class);


    @Autowired
    private BusRepository busRepository;

//    @Override
//    public BusDao saveAllBusDetails(BusDto busDto) {
//        BusDao busDao=new BusDao();
//        busDao.setBusNumber(busDto.getBusNumber());
//        busDao.setCapacity(busDto.getCapacity());
//        busDao.setModel(busDto.getModel());
//        busDao.setType(busDto.getType());
//        busDao.setRoute(busDto.getRoute());
//        busDao.setAvailableSeats(busDto.getAvailableSeats());
//        busDao.setOperator(busDto.getOperator());
//        busDao.setDepartureDateTime(busDto.getDepartureDateTime());
//        busDao.setArrivalDateTime(busDto.getArrivalDateTime());
//        busDao.setContactNumber(busDto.getContactNumber());
//        busDao.setOrigin(busDto.getOrigin());
//        busDao.setDestination(busDto.getDestination());
//        busRepository.save(busDao);
//        System.out.println(" All Bus Details Are saved successfully " +busDao);
//        return busDao;
//    }
        @Override
        public BusDao saveAllBusDetails(BusDto busDto) {
        BusDao busDao = new BusDao();
        BeanUtils.copyProperties(busDto, busDao);
        BusDao savedBus = busRepository.save(busDao);
        System.out.println("All Bus Details Are saved successfully: " + savedBus);
        return savedBus;
}

    public List<BusDao> getAllBusDetails() {
         List<BusDao> daoList=busRepository.findAll();
       // logger.info("All bus details fetched successfully. Total {} buses found.", daoList.size());
        System.out.println("All bus details fetched successfully. total {} busses found "+daoList.size());

        return daoList;
    }

    @Override
    public ResultEntity getAllBusDetailsList() {
        List<BusDao> list=busRepository.findAll();
        System.out.println("All Bus Details successfully. total buses are "+list.size());
        return  new ResultEntity("login successfully and available buses are",list);
    }

    @Override
    public ResultEntity getBusByOriginAndDestination(String origin, String destination) {
        BusDao existBus = null;
        try {
            existBus = busRepository.findByOriginAndDestination(origin, destination);

            if (existBus == null) {
                return new ResultEntity("busses are not available", null);
            }
            return new ResultEntity("available busses are ", existBus);
        } catch (Exception e) {
            System.out.println("failed to fetched bus details " + e);
        }
        return new ResultEntity("data doesn't exit", existBus);
    }
}
