package com.zkteco.userservice.repository;

import com.zkteco.userservice.dao.UserServiceDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserServiceRepository extends JpaRepository<UserServiceDao, Long>{
   Optional<UserServiceDao> findByEmailAndPassword(String email, String password);
}
