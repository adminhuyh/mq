package com.boot.service;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.boot.dao.UserDao;
import com.boot.domain.User;
import com.google.gson.Gson;


@Service
@Transactional(readOnly=true)
public class UserService2 {
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
   
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public  void hah(){
    	    User user =new User();
    	    user.setAddress("dizhis");
		    user.setAge("45");  
		    user.setSex("0");
		    user.setName("adminsz");
		    userDao.save(user);
		    Integer.parseInt("fdfd");
    }
    @Transactional
    public  void updateUserOne(){        	
        	System.out.println("===============================");
    	    User user =new User();
    	    user.setAddress("updatuseronde");
		    user.setAge("42");  
		    user.setSex("0");
		    user.setName("updatuseronde");
		    user.setCreateTime(new Date());				    
		    userDao.save(user);		 
		    try{
		    	updateUserTwo();	
		    }catch(Exception e){
		    	System.out.println("dfffdfdfdfdfsf");
		    	System.out.println("dfffdfdfdfdfsf");
		    }
		        	
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void updateUserTwo(){    	      	   
    	    User user =new User();
  	        user.setAddress("updatuseronde");
		    user.setAge("45");  
		    user.setSex("0");
		    user.setName("updatuseronde");
		    user.setCreateTime(new Date());
		    userDao.save(user);
		    Integer.parseInt("wewewe"); 
		   
    	
    }
    @Transactional
    public void findUserOne(){
    	/*User u=userDao.findOne("4028800b675846bc01675875c651002f");
    	u.setAge("19");
    	System.out.println(u.getAge());*/
    	User user=userDao.getUserById("4028800b675846bc01675875c651002f");
    	//user.setAddress("tongyaoshihuairen");
    	System.out.println(user.getImgurl());
    	
    }
    
    @Transactional
    public  void updateUserThree(){        	
        	System.out.println("===============================");
    	    User user =new User();
    	    user.setAddress("updatuseronde");
		    user.setAge("42");  
		    user.setSex("0");
		    user.setName("huyh");
		    user.setCreateTime(new Date());	
		    user.setProductNum(100);
		    userDao.save(user);		 
		  /*  try{
		    	updateUserTwo();	
		    }catch(Exception e){
		    	System.out.println("dfffdfdfdfdfsf");
		    	System.out.println("dfffdfdfdfdfsf");
		    }		        	*/
		    
		    User u = userDao.getUserByName("huyh");
    	    u.setAddress("jhdjfhdf");
		    u.setAge("14");  
		    u.setSex("0");
		    u.setName("admin");
		    u.setCreateTime(new Date());				    
		    userDao.save(u);		 
    }
    @Transactional
    public  void updateUserFour(){        	
        	System.out.println("===============================");
    	    User user = userDao.getUserByName("huyh");
    	    user.setAddress("updatuseronde");
		    user.setAge("42");  
		    user.setSex("0");
		    user.setName("admin");
		    user.setCreateTime(new Date());				    
		    userDao.save(user);		 
		  
    }
    //4028800b67d99eca0167d9a786f10008
    @Transactional
    public  void updateUserFive(){        	
        	System.out.println("===============================");
    	    User user = userDao.findOne("4028800b67d99eca0167d9a786f10008");
    	    user.setProductNum(99);
		  //  userDao.save(user);	
		    
    	    userService.testt();
		   /* User u=userDao.findOne("4028800b67d99eca0167d9a786f10008");
		    System.out.println(u.getProductNum());*/
		  
    }
    @Transactional
    public  void updateUserSix(){        	
        	System.out.println("===============================");
    	    User user = userDao.findOne("4028800b67d99eca0167d9a786f10008");
    	    System.out.println(user.getProductNum());
		    //userDao.save(user);		 
		  
    }
	
}
