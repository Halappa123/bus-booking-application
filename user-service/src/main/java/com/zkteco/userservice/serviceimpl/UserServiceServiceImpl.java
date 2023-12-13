package com.zkteco.userservice.serviceimpl;

import com.zkteco.userservice.dao.UserServiceDao;
import com.zkteco.userservice.dto.BusService;
import com.zkteco.userservice.dto.UserServiceDto;
import com.zkteco.userservice.repository.UserServiceRepository;
import com.zkteco.userservice.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class UserServiceServiceImpl implements UserServiceService {

   // private static final Logger logger = LoggerFactory.getLogger(UserServiceServiceImpl.class);

    private final String baseUrl="http://localhost:8100/bus-api";


    @Autowired
    private UserServiceRepository userServiceRepository;

    @Override
    public UserServiceDao saveRegistredUser(UserServiceDto userServiceDto) {
       UserServiceDao dao=new UserServiceDao();
       dao.setFirstName(userServiceDto.getFirstName());
       dao.setLastName(userServiceDto.getLastName());
       dao.setEmail(userServiceDto.getEmail());
       dao.setPhNo(userServiceDto.getPhNo());
       dao.setPassword(userServiceDto.getPassword());
       userServiceRepository.save(dao);
       System.out.println("data saved successfully"+dao);
       return dao;

    }

    @Override
    public Flux<BusService> loginByEmailAndPassword(String email, String password) {
           Optional<UserServiceDao> existUser=(userServiceRepository.findByEmailAndPassword(email, password));
           if (existUser.isEmpty()){
               return null;
           }

           System.out.println("user login successfully "+existUser);
           System.out.println(baseUrl);

        WebClient webClient=WebClient.create(baseUrl);
        Flux<BusService> busService=webClient.get()
                .uri("/get_all_bus_details")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BusService.class);
        System.out.println(busService);

        System.out.println("login successfully to bus service and available busses are "+busService);
        return busService;

    }

    @Override
    public UserServiceDao loginByPhNoPassword(Long phNo, String password) {
       UserServiceDao existUser= userServiceRepository.findByPhNoAndPassword(phNo,password);
       if (existUser==null){
          return null;
       }
       if (password!=null && phNo!=null){
           //verify the password
           if (existUser.getPassword().equals(password) && existUser.getPhNo().equals(phNo)){
               return existUser;
           }
           else {
               return null;
           }
       }
       return existUser;
    }
}
