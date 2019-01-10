package com.boot.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{

	
	/**
	 * 
	 */
	private String name;
	private BigDecimal account;
	private String age;
	private String sex;
	private String address;
	private Date createTime;
	
	private Integer productNum;
	
   // private String tempName=name;
	
	private String imgurl="/image/url/haha";


	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getAccount() {
		return account;
	}
	public void setAccount(BigDecimal account) {
		this.account = account;
	}
	@Transient
	public String getImgurl() {
		return this.address+"hdfkdjfdkf";
	}
	@Transient
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
//	public String getTempName() {
//		return tempName;
//	}
//	public void setTempName(String tempName) {
//		this.tempName = tempName;
//	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	
	
	
	
	
	
}
