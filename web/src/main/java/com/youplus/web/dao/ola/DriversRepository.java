package com.youplus.web.dao.ola;


import com.youplus.web.entity.ola.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository extends JpaRepository<Driver, Integer> {

  Driver findById(Integer id);
}
