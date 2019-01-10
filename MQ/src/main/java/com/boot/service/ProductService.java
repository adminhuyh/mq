package com.boot.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.common.RedissonManage;
import com.boot.dao.UserDao;
import com.boot.domain.User;



@Service
public class ProductService {
    
	@Autowired 
	private JmsMessagingTemplate jmsTemplate;  
	
	
	
	public void convertAndSend(String destination,Object obj){
		jmsTemplate.convertAndSend(destination, obj);
	}
	
	
	public void testProduct(String destination ,User o){		
		convertAndSend(destination,o);
	}
	
	
}
