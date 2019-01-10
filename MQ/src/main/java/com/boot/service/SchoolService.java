package com.boot.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.tomcat.jni.Thread;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.common.RedissonManage;
import com.boot.dao.SchoolDao;
import com.boot.dao.UserDao;
import com.boot.domain.User;



@Service
public class SchoolService {
    
	@Autowired
	private SchoolDao schoolDao;
	

	@Autowired
	private UserDao userDao;
	
	
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public  void testQueryOne(){
    	  
    	    User user =new User();    	   
    	    user.setAddress("first");
		    user.setAge("20");  
		    user.setSex("0");
		    user.setName("first");
		    userDao.save(user);
		    
		    
		    user =new User();    	   
    	    user.setAddress("second");
		    user.setAge("50");  
		    user.setSex("0");
		    user.setName("second");
		    userDao.save(user);
		    
		    Integer.parseInt("xxxxxxxxx");
		  
		/*    
		    User query=userDao.getUserByName("adminsz");
		    System.out.println(query.getVersion()+"**************");
		    System.out.println("===============end===============");*/
		    
    }
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void temp(){
        
    	User user2 = userDao.findOne("121211");
    	System.out.println("versionxxxxxxxxxxx="+user2.getVersion());
    	user2.setAccount(user2.getAccount().add(new BigDecimal("10")));
    	user2.setAge("345");
    	userDao.save(user2);
    	user2 = userDao.findOne("121211");
      	System.out.println("**************  account = "+user2.getAccount() + "version = "+user2.getVersion());
    	
    	User user3 = userDao.findOne("121211");
    	user3.setAccount(user3.getAccount().add(new BigDecimal("10")));
    //	user3.setAge("320");
    	user3=userDao.save(user3);
    	user3 = userDao.findOne("121211");
      	System.out.println("**************  account = "+user3.getAccount() + "version = "+user3.getVersion());
    }
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
	public void tempff(){
		
		 User user1 = userDao.findOne("121211");
  	    System.out.println("**************  accountkaishi = "+user1.getAccount() + "version kaishi= "+user1.getVersion());
  	    
  	    user1.setAccount(new BigDecimal(147));  	   
  	    userDao.save(user1);
  	    user1 = userDao.findOne("121211");
  	    System.out.println("**************  account = "+user1.getAccount() + "version = "+user1.getVersion()); 
	}
	
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testSwSchool() {
    	User user1 = userDao.findOne("123456");
    	System.out.println("age"+user1.getVersion());
    	user1.setAge("23");
    	
    	userDao.save(user1);    	
    	//Integer.parseInt("xxx");
          	        
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testSwSchoolOne() {
    	User user1 = userDao.findOne("123456");
    	System.out.println("address"+user1.getVersion());
    	user1.setAddress("newasxdd");
    	userDao.save(user1);    	
    //	Integer.parseInt("xxx");
          	        
    }
	
}
