package com.zkteco.busbookingservice.serviceimpl;

import com.zkteco.busbookingservice.dao.BusBookingDao;
import com.zkteco.busbookingservice.dto.BusService;
import com.zkteco.busbookingservice.repository.BusBookingRepository;
import com.zkteco.busbookingservice.service.BusBookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class BusBookingServiceImpl implements BusBookingService {

    private final String baseUrl="http://localhost:8100/bus-api";


    @Autowired
    private BusBookingRepository busBookingRepository;
    @Override
    public BusBookingDao saveBusByOriginAndDestination(String origin, String destination, String departureDateTime, int seatNo) {
// Check if bus already exists with same parameters
        BusBookingDao existingBooking = busBookingRepository.findByOriginAndDestinationAndDepartureDateTimeAndSeatNo(origin, destination, departureDateTime, seatNo);
        if (existingBooking != null) {
            return existingBooking; // Bus already booked
        }

        // Retrieve bus service from WebClient
        WebClient webClient = WebClient.create(baseUrl);

        Flux<BusService> busServiceFlux = webClient.get()
                .uri("/book_bus/{origin}/{destination}/{departureDateTime}")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BusService.class)
                .filter(bus -> origin.equals(bus.getOrigin()) && destination.equals(bus.getDestination())
                        && departureDateTime.equals(bus.getDepartureDateTime()));

        // Collect bus service into a list
        List<BusService> matchingBuses = busServiceFlux.collectList().block();

        // Check if any bus found
        if (matchingBuses.isEmpty()) {
            return null; // No matching bus found
        }

        BusBookingDao busBookingDao=new BusBookingDao();
        BeanUtils.copyProperties(matchingBuses,busBookingDao);

        return busBookingRepository.save(busBookingDao);


    }

}
