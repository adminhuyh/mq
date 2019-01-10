package com.boot.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order")
public class Order extends AbstractEntity{

	
	/**
	 * 
	 */
	
   private String orderNumber;
   private Integer orderStauts;
   
   private String content;

public String getOrderNumber() {
	return orderNumber;
}

public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}


public Integer getOrderStauts() {
	return orderStauts;
}

public void setOrderStauts(Integer orderStauts) {
	this.orderStauts = orderStauts;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}
   
   
   
   
	
	
}
