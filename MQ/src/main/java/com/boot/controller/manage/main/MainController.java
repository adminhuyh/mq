
package com.boot.controller.manage.main;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.config.Constant;
import com.boot.domain.User;
import com.boot.service.ConsumerService;
import com.boot.service.ProductService;
import com.boot.service.UserService;
import com.boot.service.UserService2;
import com.dns.common.terminal.base.SendUtil;
@Controller
@RequestMapping("/manage/main")
public class MainController {
	@Autowired
    private UserService  userService;
	
	@Autowired
    private UserService2 userService2;
	

	@Autowired
    private ProductService productSerivce;
	

	@Autowired
    private ConsumerService consumerSerivce;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		
		return "ok";
	}

	@RequestMapping("/testOne")
	@ResponseBody
	public String testOne(){
		return "ok";
	}	
	@RequestMapping("/testsw")
	@ResponseBody
	public  void testsw(HttpServletRequest request){
		System.out.println("=================================request="+request.toString());			
		userService.update();
	//	userService.one();
		System.out.println("==========cccccccccccccccccccccc===============");
//		
		
	}  
	/*public static void main(String[] args) {
		//final String url="http://127.0.0.1:8080/manage/main/testsw";
		try {
			SendUtil.sendToUrl(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++){
			try {
				SendUtil.sendToUrl(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

		
		final	String  url="http://127.0.0.1:8080/manage/main/testP";
        for(int i=0;i<1000;i++){
        	try {
    			SendUtil.sendToUrl(url);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	
		}
		for(int i=0;i<10;i++){
			try {				
				new Thread(new Runnable() {
					
					public void run() {
						try {
							SendUtil.sendToUrl(url);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}*/
	
	@RequestMapping("/testP")
	@ResponseBody
	public  void testP(HttpServletRequest request){
		String destination="";
		User u=new User();
		u.setSex("1");
		u.setAddress("aaaaaaaaaaa");
		
		for(int i=0;i<=100;i++){
			productSerivce.testProduct(Constant.KEYONE, u);
		/*	productSerivce.testProduct(Constant.KEYONE, u);
			productSerivce.testProduct(Constant.KEYONE, u);
			productSerivce.testProduct(Constant.KEYONE, u);*/
		}
//		
		
	} 
	/*
	@RequestMapping("/testC")
	@ResponseBody
	public  void testC(HttpServletRequest request){
		consumerSerivce.
//		
		
	}  */
	
	
	@RequestMapping("/testSW")
	@ResponseBody
	public  void testC(HttpServletRequest request){
		userService2.updateUserOne();
		
		
	}
	@RequestMapping("/testFind")
	@ResponseBody
	public  void testFind(HttpServletRequest request){
		userService2.findUserOne();
		
		
	}
	
	public static void main(String[] args) {
		User user= new User();
		user.setName("admin");
		System.out.println(user.getName());	
	}
	@RequestMapping("/testSwTwo")
	@ResponseBody
	public  void testSwTwo(HttpServletRequest request){
		userService2.updateUserFive();
	//	userService2.updateUserSix();
	//	userService2.updateUserFour();
		
	}
	
}
