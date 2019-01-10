package com.boot.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.boot.domain.User;

public interface UserDao extends JpaRepository<User, String>{
    
	@Query(" from User ")
	List<User> getUser();
	
	@Query(value="select * from user where id =?1",nativeQuery = true)
	User getUserById(String id);
	
	@Query(value="select * from user where name =?1",nativeQuery = true)
	User getUserByName(String name);
	
	@Modifying
	@Query(value=" UPDATE USER SET account = account+10  WHERE id='4028800b67114b2201671150e2de0000' ",nativeQuery = true)
	void updateUser();
	
	@Modifying
	@Query(value=" UPDATE USER SET account = account+10  WHERE id=?1 ",nativeQuery = true)
	void updateUser(String id);
	
	@Query(value="select account from user where id =?1",nativeQuery = true)
    BigDecimal  getUserAccountByName(String id);
	
	@Modifying
	@Query(value="UPDATE USER SET account = 1478  WHERE id=?1",nativeQuery = true)
    void  updateAccount(String id);
	
	@Modifying
	@Query(value="UPDATE USER SET age = 14  WHERE id=?1",nativeQuery = true)
	void  updateAge(String id);
	
}
