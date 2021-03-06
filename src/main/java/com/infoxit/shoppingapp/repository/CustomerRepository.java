package com.infoxit.shoppingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infoxit.shoppingapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	@Query(value = "select * from customer where username =:username and password =:password", nativeQuery = true)
	public Customer findUserByUserNameAndPassword(String username, String password);
}
