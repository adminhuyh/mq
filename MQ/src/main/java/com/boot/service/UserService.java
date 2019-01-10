package com.boot.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.boot.common.RedissonManage;
import com.boot.dao.UserDao;
import com.boot.domain.User;
import com.dns.common.terminal.base.SendUtil;
import com.google.gson.Gson;



@Service
/*@Transactional(readOnly=true)*/
public class UserService {
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService2 userService2;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
		
	private int i=0;
	
	public List<User> getUser(){
		
		return userDao.getUser();
	}
	
    @Transactional(rollbackFor=Exception.class)
	public void saveUserOne(String id){
    	System.out.println("id============="+id);
		User user=new User();	  
		try {
			    user.setAddress("address");
			    user.setAge("20");  
			    user.setSex("1");
			    user.setName("shaopent");
		  		User u=userDao.save(user);
		  		System.out.println(u.getAddress());
		  		//u.setAddress("address");
		  	    u.setAddress("newAddress");		  	
		  		System.out.println(u.getAddress());

			   Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
    @Transactional(rollbackFor=Exception.class)
  	public void findById(String id){
      	System.out.println("id============="+id);  	

	    User eee =new User();
	    eee.setAddress("areassssss");
	    eee.setAge("36");  
	    eee.setSex("1");
	    eee.setName("adminsz");
	    userDao.save(eee);
	    
	    //userService2.hah();
	    
  	}
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    private void hah(){
    	    User user =new User();
    	   
    	    user.setAddress("dizhis");
		    user.setAge("45");  
		    user.setSex("0");
		    user.setName("adminsz");
		    userDao.save(user);
		    Integer.parseInt("fdfd");
    }
    @Transactional(rollbackFor=Exception.class)
    public void  update(){       
    	RLock lock=RedissonManage.getLock(String.valueOf(i));
    	System.out.println("xxxxxxxxxxxxxxxxxxxx======begin"+i++);
    	User user=userDao.findOne("4028800b671618d0016716364a2d001e");    
    	System.out.println(user.toString()+"888888888"+i);
    	user.setAccount(user.getAccount().add(new BigDecimal(10)));	
    	userDao.save(user);    	
    	//Integer.parseInt("sss");
    	System.out.println("xxxxxxxxxxxxxxxxxxxx======end");
    	lock.unlock();
    }
    private  void hahaha(){
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("testhhhhhhhhhhhhhhhhhhhhhhh");
    }
    public synchronized void one(){    	
    	update();
    	
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testt(){
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	User u=userDao.findOne("4028800b67d99eca0167d9a786f10008");
    	System.out.println(u.getProductNum());
    	
    	
    }
    
    @Transactional(rollbackFor=Exception.class)
    public  void testQuery(){
    	    User user =new User();    	   
    	    user.setAddress("dizhis");
		    user.setAge("45");  
		    user.setSex("0");
		    user.setName("adminsz");
		    userDao.save(user);
		    //Integer.parseInt("ssss");
		   
		  //  userService.testQueryOne();		    	
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   		    	
		    System.out.println("dfffffffffffffffff");
		    
		   
		/*    
		    User query=userDao.getUserByName("adminsz");
		    System.out.println(query.getVersion()+"**************");
		    System.out.println("===============end===============");*/
		    
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public  void testQueryOne(){
    	  
    	    User user =userDao.findOne("4028800b67e4a4d60167e4a67ed90003");
    	    user.setAccount(user.getAccount().add(new BigDecimal(10)));
    	   /* user.setAddress("first");
		    user.setAge("20");  
		    user.setSex("0");
		    user.setName("first");
		    userDao.save(user);*/
		    //userDao.updateUser(user.getId());
		    userDao.save(user);
		    
		//    Integer.parseInt("xxxxxxxxx");
		  
		/*    
		    User query=userDao.getUserByName("adminsz");
		    System.out.println(query.getVersion()+"**************");
		    System.out.println("===============end===============");*/
		    
    }
    

    @Transactional(rollbackFor=Exception.class)
    public void saveUserOne(){
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	User u=userDao.findOne("4028800b67d99eca0167d9a786f10008");
    	System.out.println(u.getProductNum());
    	//saveUserTwo();    	
    }
    @Transactional(rollbackFor=Exception.class)
    public void saveUserTwo(){
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	User u=userDao.findOne("4028800b67d99eca0167d9a786f10008");
    	System.out.println(u.getProductNum());
    	
    	
    }
    @Transactional(rollbackFor=Exception.class)
    public void testSwOne(){
    	
    	User user=userDao.getUserByName("admin");
    	System.out.println("11111**************"+user.getVersion());
    	try {
			   String message = SendUtil.sendToUrl("http://localhost:8080/terminal/testSwOneT");
			   System.out.println("*********************************分界线***************************************begin");
			   Gson gson = new Gson();
			   Map map=gson.fromJson(message, Map.class);
			   String messages=(String)map.get("message");
			   System.out.println("sssssssssssssss"+message);
			   userDao.flush();
			   User user1=userDao.getUserByName("admin");
			//   String address = userDao.getUserById("12121").getAddress();
			   System.out.println(user1.getAddress());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
     
    }
    @Transactional(rollbackFor=Exception.class)
    public void testSwOneT(){
    	
    	User u=userDao.getUserByName("admin");
    	System.out.println("22222222**************"+u.getVersion());

   //     u.setAge("12");
        u.setAddress("nnnn");  
        userDao.save(u);
    }
    @Transactional(rollbackFor=Exception.class)
    public void testSwTwo(){
    	
    	BigDecimal  account=userDao.getUserAccountByName("121211");    	
    	System.out.println("111111**************"+account.doubleValue());
    	try {
    		String message = SendUtil.sendToUrl("http://localhost:8080/terminal/testSwTwoT");
    		System.out.println("*********************************分界线***************************************begin");
    		Gson gson = new Gson();
    		Map map=gson.fromJson(message, Map.class);
    		String messages=(String)map.get("message");
    		System.out.println("sssssssssssssss"+message);
    		Thread.sleep(2000);        	
        	userDao.updateUser("121211");
        	BigDecimal  account1=userDao.getUserAccountByName("121211");
        	System.out.println("333333333**************"+account1.doubleValue());
        	
        	
    		
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	
    	
    }
    @Transactional(rollbackFor=Exception.class)
    public void testSwTwoT(){
    	
    	userDao.updateUser("121211");
    	
    	System.out.println("222222222**************xxx");
    	
        
    }
    @Transactional(rollbackFor=Exception.class)
    public void  testSwThree(){
    	try {
    		
    		BigDecimal  account0=userDao.getUserAccountByName("121211");
        	System.out.println("000000**************"+account0.doubleValue());
        	
        	String message = SendUtil.sendToUrl("http://localhost:8080/terminal/testSwTwoT");
    		System.out.println("*********************************分界线***************************************begin");
    		Gson gson = new Gson();
    		Map map=gson.fromJson(message, Map.class);
        	
        	
        	userDao.updateUser("121211");
        	BigDecimal  account1=userDao.getUserAccountByName("121211");
        	System.out.println("111111**************"+account1.doubleValue());
        	userDao.updateUser("121211");
        	BigDecimal  account2=userDao.getUserAccountByName("121211");
        	System.out.println("222222**************"+account2.doubleValue());
        	userDao.updateUser("121211");
        	BigDecimal  account3=userDao.getUserAccountByName("121211");
        	System.out.println("3333333*************"+account3.doubleValue());
        	
          	
    		
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
       	
    }
    //
    @Transactional(rollbackFor=Exception.class)
    public void  testSwFour(){
    	
    	
    	     try{
    	    	 schoolService.tempff();      	   
    	    	 
    	    	 schoolService.temp();         	
    	    	 
    	     }catch(Exception e){
    	    	 System.err.println("exxxxxxxxxx"+e);
    	     }
    	
          

    }
    @Transactional(rollbackFor=Exception.class)
    public void testSwFourT() throws InterruptedException{
       
    	User user1 = userDao.findOne("121211");
    	user1.setAccount(user1.getAccount().add(new BigDecimal("10")));
    	userDao.save(user1);
    	user1 = userDao.findOne("121211");
      	System.out.println("另一个  account = "+user1.getAccount() + "version = "+user1.getVersion());
    	Thread.sleep(5000);
    	
        
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testSwFive() {
    	User user1 = userDao.findOne("123456");
    	System.out.println("waibain"+user1.getVersion());
    	user1.setAccount(new BigDecimal("541"));
    	userDao.save(user1);
        schoolService.testSwSchool();
        schoolService.testSwSchoolOne();
    		
    	
          	        
    }
    
    
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testTypeOne() throws Exception {
      System.out.println("11111111111111111111111111111111");
      //掉接口
      String message = SendUtil.sendToUrl("http://localhost:8080/terminal/testTypeTwo");
	   
      Thread.sleep(10000);
      
      userDao.updateAccount("123456");
      
    	
          	        
    }
    @Transactional(rollbackFor=Exception.class)
    public void testTypeTwo() throws InterruptedException {
        System.out.println("begin");
    /*    
        User user = userDao.findOne("123456");
		user.setAccount(new BigDecimal("1000"));
		userDao.save(user);*/
        
     //   userDao.updateAccount("123456");
        
      //  Thread.sleep(10000);
        new Thread(new Runnable() {
			
			public void run() {
				try {
					userService.duoxiancheng();
				} catch (Exception e) {
					System.err.println("xxxxxxxxfjkdflasflsdafsdafjkladsfsdjka"+e);
				}
			}
		}).start();
      //  userDao.updateAccount("123456");
        System.out.println("end");
    	
          	        
    }
    
    
    //@Transactional(rollbackFor=Exception.class)
    public void duoxiancheng() throws Exception {
    	userDao.updateAccount("123456");
    	//userDao.updateAccount("123456");
	/*	User user = userDao.findOne("123456");
		System.out.println(user.getId());
		user.setAccount(new BigDecimal("1000"));
		userDao.save(user);*/
		//userDao.save(user);
		//Integer.parseInt("xxxx");
      
    	
          	        
    }
    
    
    @Transactional(rollbackFor=Exception.class)
    public void testTypeThree() {
        System.out.println("begin");
        userService.testTypeThreee();
        userService.testTypeThreef();
        System.out.println("end");
    	
          	        
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testTypeThreee() {
        System.out.println("beginxxxxxxxxxx");
        User user = userDao.findOne("123456");
		System.out.println(user.getVersion());
		user.setAccount(new BigDecimal("1000"));
		user=userDao.save(user);
		System.out.println(user.getVersion());
        System.out.println("endxxxxxxxxxxx");
    	
          	        
    }
    @Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRES_NEW)
    public void testTypeThreef() {
        System.out.println("beginfffffffffffff");
        User user = userDao.findOne("123456");
		System.out.println(user.getVersion()+"xxxx"+user.getAccount());
		/*user.setAccount(new BigDecimal("7000"));
		user=userDao.save(user);
        System.out.println("endffffffffff");*/
    	
          	        
    }
    //findUserById
    //@Transactional(rollbackFor=Exception.class)
    public User findUserById(String id ) {
        System.out.println("beginfffffffffffff");
        User user = userDao.findOne("123456");
	    return user;
    	
          	        
    }
    
    
   
}
