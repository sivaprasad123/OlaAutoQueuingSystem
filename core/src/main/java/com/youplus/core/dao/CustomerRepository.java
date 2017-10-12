package com.youplus.core.dao;


import com.youplus.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  Customer findById(Integer id);
}
