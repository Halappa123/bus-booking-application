package com.zkteco.userservice.controller;

import com.zkteco.userservice.dao.UserServiceDao;
import com.zkteco.userservice.dto.BusService;
import com.zkteco.userservice.dto.UserServiceDto;
import com.zkteco.userservice.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class UserServiceController {

    @Autowired
    private UserServiceService userServiceService;

    @PostMapping("/user_registry")
    public ResponseEntity<UserServiceDao> registerUser(@RequestBody UserServiceDto userServiceDto){
        return new ResponseEntity<UserServiceDao>(userServiceService.saveRegistredUser(userServiceDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user_login/{email}/{password}")
    public ResponseEntity<Flux<BusService>> loginUserToBusServiceThrowEmailAndPassword(@PathVariable String email, @PathVariable String password){
      return new ResponseEntity<>(userServiceService.loginByEmailAndPassword(email,password),HttpStatus.ACCEPTED);
    }
}
