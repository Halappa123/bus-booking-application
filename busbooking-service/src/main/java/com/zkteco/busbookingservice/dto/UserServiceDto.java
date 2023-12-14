package com.zkteco.busbookingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long phNo;
    private String password;

}
