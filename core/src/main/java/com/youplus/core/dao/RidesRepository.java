package com.youplus.core.dao;


import com.youplus.core.entity.Ride;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidesRepository extends JpaRepository<Ride, Integer> {

  public List<Ride> findAllOrderByStatus();
}
