package com.zkteco.busservice.serviceimpl;

import com.zkteco.busservice.dao.BusDao;
import com.zkteco.busservice.dto.BusDto;
import com.zkteco.busservice.dto.ResultEntity;
import com.zkteco.busservice.repository.BusRepository;
import com.zkteco.busservice.service.BusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    private static final Logger logger = LoggerFactory.getLogger(BusService.class);


    //private static final Logger logger = LoggerFactory.getLogger(BusServiceImpl.class);


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

    /*
         This is another way to set the details to database and get the details from database using  beanutils properties
    */
    @Override
    public BusDao saveAllBusDetails(BusDto busDto) {
        BusDao busDao = new BusDao();
        BeanUtils.copyProperties(busDto, busDao);
        BusDao savedBus = busRepository.save(busDao);
        System.out.println("All Bus Details Are saved successfully: " + savedBus);
        return savedBus;
    }

    public List<BusDao> getAllBusDetails() {
        List<BusDao> daoList = busRepository.findAll();
        // logger.info("All bus details fetched successfully. Total {} buses found.", daoList.size());
        System.out.println("All bus details fetched successfully. total {} busses found " + daoList.size());

        return daoList;
    }

    @Override
    public ResultEntity getAllBusDetailsList() {
        List<BusDao> list = busRepository.findAll();
        System.out.println("All Bus Details successfully. total buses are " + list.size());
        return new ResultEntity("login successfully and available buses are", list);
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

    @Override
    public ResultEntity deleteById(String busId) {
        Optional<BusDao> exist = busRepository.findById(busId);
        if (exist.isPresent()) {

            busRepository.deleteById(busId);
            logger.info("The deleted bus details is :{} ",exist);
            return new ResultEntity("bus details are deleted successfully", exist);
        } else {
            logger.info("failed to delete  the bus details with bus id {} ",exist);
            return new ResultEntity("invalid id please check id given", exist);
        }
    }

    @Override
    public ResultEntity deleteAllDetails() {
        try {
            busRepository.deleteAll();
            return new ResultEntity("All details are deleted successfully", null);

        } catch (Exception e) {

            return new ResultEntity("fails to delete all details ", null);
        }
    }

    @Override
    public List<BusDao> getBusDetailsByOriginDestinationAndDepartureDateTime(String origin, String destination, String departureDateTime) {
        List<BusDao> buses = busRepository.findByOriginAndDestinationAndDepartureDateTimeAndArrivalDateTime(origin, destination, departureDateTime);

        if (buses.isEmpty()) {
            logger.info("No buses found for the given criteria. Origin: {}, Destination: {}, Departure Time:  {}", origin, destination, departureDateTime);
            return null; // or return an empty list based on your requirements
        }

        logger.info("Buses found: {}", buses);
        return buses;
    }
    }

