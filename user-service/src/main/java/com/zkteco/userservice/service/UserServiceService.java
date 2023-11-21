package com.zkteco.userservice.service;

import com.zkteco.userservice.dao.UserServiceDao;
import com.zkteco.userservice.dto.BusService;
import com.zkteco.userservice.dto.UserServiceDto;
import reactor.core.publisher.Flux;

public interface UserServiceService {


    UserServiceDao saveRegistredUser(UserServiceDto userServiceDto);

    Flux<BusService> loginByEmailAndPassword(String email, String password);
}
