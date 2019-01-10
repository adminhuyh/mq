package com.boot.service;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.config.Constant;
import com.boot.dao.UserDao;
import com.boot.domain.User;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;


@Service
public class ConsumerService {
	
	@Autowired 
	private JmsMessagingTemplate jmsTemplate;  
	
	@Autowired
	private UserDao userDao;
		
	@JmsListener(destination = Constant.KEYONE)
	public  void testCOne(ObjectMessage o) throws JMSException{
		System.out.println("oneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneoneone");
	    Integer.parseInt("dfdf");
	  
	}
	
	
	@JmsListener(destination = Constant.KEYONE)
	public  void testCTwo(ObjectMessage o) throws JMSException{
		System.out.println("twotwotwowtwotwotwotwowtwotwotwotwowtwotwotwotwowtwotwotwotwowtwotwotwotwowtwotwotwotwowtwo");

	    Integer.parseInt("dfdf");
	    
	  
	}
	
	@JmsListener(destination = Constant.KEYONE)
	public  void testThree(ObjectMessage o) throws JMSException{
		System.out.println("threethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethreethree");
		 Integer.parseInt("dfdf");
	}
}
