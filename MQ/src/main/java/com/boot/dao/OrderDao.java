package com.boot.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.boot.domain.Order;
import com.boot.domain.User;

public interface OrderDao extends JpaRepository<Order, String>{
    
	@Query(" from Order ")
	List<User> getOrder();
	
	@Query(value="select * from order where id =?1",nativeQuery = true)
	User getOrderById(String id);
	
	@Query(value="select * from order where order_number =?1",nativeQuery = true)
	User getUserByOrderNumber(String orderNumber);
	
	 

	
}
