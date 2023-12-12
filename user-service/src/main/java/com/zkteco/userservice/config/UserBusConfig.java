package com.zkteco.userservice.config;

import com.zkteco.userservice.dao.UserServiceDao;
import com.zkteco.userservice.dto.BusService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBusConfig {
    private BusService busService;
    private UserServiceDao userServiceDao;
}
