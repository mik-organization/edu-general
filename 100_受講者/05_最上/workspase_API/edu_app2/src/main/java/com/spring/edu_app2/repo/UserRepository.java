package com.spring.edu_app2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.edu_app2.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
}
