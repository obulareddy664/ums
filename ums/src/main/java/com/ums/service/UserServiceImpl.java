package com.ums.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ums.UserException;
import com.ums.entity.UserCart;
import com.ums.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<UserCart> getById(Integer id) throws UserException {
		
	Optional<UserCart>	user=userRepository.findById(id);
	
	if(user.isPresent()) {
		return user;
	}else {
		throw new UserException("user is not found with id "+id);
	}
		
	}

}
