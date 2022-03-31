package com.example.RestLOgin.ApiRestLoginTest.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RestLOgin.ApiRestLoginTest.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
	public  User findOneByEmailAndPassword(String email, String password);
    
  //  public abstract User findByemail(String usuario);
}