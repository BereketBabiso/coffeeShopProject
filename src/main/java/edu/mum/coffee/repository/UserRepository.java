package edu.mum.coffee.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	public List<User> findByUsername(String username);
	

}
