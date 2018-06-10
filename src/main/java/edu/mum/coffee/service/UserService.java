package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.PersonRepository;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> findByEmail(String userName) {
		return userRepository.findByUsername(userName);
	}

	public User findById(int id) {
		return userRepository.findOne(id);
	}

	public void removePerson(User user) {
		userRepository.delete(user);
	}
}
