package com.youplus.core.dao;


import com.youplus.core.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository extends JpaRepository<Driver, Integer> {

  Driver findById(Integer id);
}
