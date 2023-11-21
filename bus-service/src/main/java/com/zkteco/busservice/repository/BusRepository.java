package com.zkteco.busservice.repository;

import com.zkteco.busservice.dao.BusDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<BusDao,String> {
}
