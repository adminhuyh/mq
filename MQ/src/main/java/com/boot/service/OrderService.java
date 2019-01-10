package com.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.dao.OrderDao;
import com.boot.dao.UserDao;
import com.boot.domain.Order;




@Service
/*@Transactional(readOnly=true)*/
public class OrderService {
    
	@Autowired
	private OrderDao orderDao;
	
	private OrderService orderService;
	
	@Transactional(rollbackFor=Exception.class)
    private void afterPay(String orderNumber){
		orderService.updateStatusafterPay(orderNumber);
		orderService.transForCoinsafterPay(orderNumber);
    	
    }
    
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    private void updateStatusafterPay(String orderNumber){
    	
    	
    }
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    private void transForCoinsafterPay(String orderNumber){
    	
    	
    }
    
	@Transactional(rollbackFor=Exception.class)
    private void createrOrder(){
    	Order order=new Order();
    	order.setOrderNumber(String.valueOf(System.currentTimeMillis()));
    	order.setOrderStauts(0);
    	order.setContent("´´½¨¶©µ¥");
    	orderDao.save(order);
    	
    	
    }
    
}  
