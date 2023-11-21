package com.zkteco.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_service")
public class UserServiceDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_PhNO")
    private Long  phNo;

    @Column(name = "USER_PASSWORD")
    private String password;
}
