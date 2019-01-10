
package com.boot.controller.manage.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.config.Constant;
import com.boot.domain.User;
import com.boot.service.ConsumerService;
import com.boot.service.ProductService;
import com.boot.service.SchoolService;
import com.boot.service.UserService;
import com.boot.service.UserService2;
@Controller
@RequestMapping("/terminal")
public class TerminalController {
	@Autowired
    private UserService  userService;
	
	@Autowired
    private SchoolService  schoolService;
    
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		
		return "ok";
	}

	
	
	@RequestMapping("/testUserSW")	
	public  void testC(HttpServletRequest request){
	    new Thread(new Runnable() {
			public void run() {				
				userService.testQueryOne();
			}
		}).start();
	    	  
	    new Thread(new Runnable() {
	 			public void run() {
	 				userService.testQueryOne();
	 			}
	 	}).start();
	    
	    new Thread(new Runnable() {
 			public void run() {
 				userService.testQueryOne();
 			}
 	}).start();
	    
	    new Thread(new Runnable() {
 			public void run() {
 				userService.testQueryOne();
 			}
 	}).start();
	    
	    new Thread(new Runnable() {
 			public void run() {
 				userService.testQueryOne();
 			}
 	}).start();
		
		

	}
	@RequestMapping("/testSwOne")
	@ResponseBody
	public String testSwOne(){
		userService.testSwOne();
		return "ok";
	}
	//testSwTwo
	@RequestMapping("/testSwOneT")
	@ResponseBody
	public Map<String,Object> testSwOneT(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwOneT();
		map.put("message", "true");
		return map;		
	}
		
	@RequestMapping("/testSwTwo")
	@ResponseBody
	public Map<String,Object> testSwTwo(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwTwo();
		map.put("message", "true");
		return map;		
	}
	@RequestMapping("/testSwTwoT")
	@ResponseBody
	public Map<String,Object> testSwTwoT(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwTwoT();
		map.put("message", "true");
		return map;		
	}
	
	@RequestMapping("/testSwThree")
	@ResponseBody
	public Map<String,Object> testSwThree(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwThree();
		map.put("message", "true");
		return map;		
	}
	@RequestMapping("/testSwFour")
	@ResponseBody
	public Map<String,Object> testSwFour(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwFour();
		map.put("message", "true");
		return map;		
	}
	@RequestMapping("/testSwFourT")
	@ResponseBody
	public Map<String,Object> testSwFourT() throws InterruptedException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwFourT();
		
		map.put("message", "true");
		return map;		
	}
	
	@RequestMapping("/testSwFive")
	@ResponseBody
	public Map<String,Object> testSwFive() throws InterruptedException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testSwFive();		
		map.put("message", "true");
		return map;		
	}
	@RequestMapping("/testTypeOne")
	@ResponseBody
	public Map<String,Object> testTypeOne() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testTypeOne();		
		map.put("message", "true");
		return map;		
	}

	@RequestMapping("/testTypeTwo")
	@ResponseBody
	public Map<String,Object> testTypeTwo() throws InterruptedException{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "false");
		userService.testTypeTwo();		
		map.put("message", "true");
		return map;		
	}
    
	@RequestMapping("/testTypeThree")
	
	public void testTypeThree() throws InterruptedException{
		Map<String,Object> map = new HashMap<String,Object>();
	/*	  User user = userService.findUserById("123456");		  
			System.out.println("controller++"+user.getVersion());*/
		
		//userService.testTypeThree();
		 userService.testTypeThreee();
	        userService.testTypeThreef();
		
	}
    
    

}
