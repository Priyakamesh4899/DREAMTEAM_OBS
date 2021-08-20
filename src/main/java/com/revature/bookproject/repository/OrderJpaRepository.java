package com.revature.bookproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.revature.bookproject.model.Order;
@Component
public interface OrderJpaRepository extends JpaRepository<Order,Integer>{

}
