package com.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.boot.domain.User;

public interface SchoolDao extends JpaRepository<User, String>{
    
	@Query(" from School ")
	List<SchoolDao> getSchool();
	
	@Query(value="select * from school where id =?1",nativeQuery = true)
	SchoolDao getSchoolById(String id);
	
	@Query(value="select * from school where name =?1",nativeQuery = true)
	SchoolDao getSchoolByName(String name);
	
	@Modifying
	@Query(value=" UPDATE USER SET content=?2  WHERE name=?1 ",nativeQuery = true)
	void updateSchoolDao(String name,String content);
	
	
}
