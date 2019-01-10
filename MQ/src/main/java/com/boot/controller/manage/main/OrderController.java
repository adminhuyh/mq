package com.boot.controller.manage.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.service.OrderService;
import com.google.gson.Gson;


public class OrderController {
	@Autowired
    private OrderService  orderService;
	
	
	
	@RequestMapping("/createOrder")
	public ModelAndView orderMain(){
		return new ModelAndView("external/order/order_main");
	}	
	
	
}
