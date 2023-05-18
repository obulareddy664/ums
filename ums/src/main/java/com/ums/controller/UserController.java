package com.ums.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ums.entity.UserCart;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@PostMapping("/user")
	public UserCart saveUser(@RequestBody UserCart user) {
		return userRepository.save(user);
	}

	@GetMapping
	public List<UserCart> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		 Optional<UserCart> user= userRepository.findById(id);
		 if(user.isPresent()) {
			 return new ResponseEntity<>(user,HttpStatus.OK);
		 }else  {
		return new ResponseEntity<>("user is not found with id: "+id,HttpStatus.NOT_ACCEPTABLE);
		 }
	}

	@DeleteMapping("/{id}")
	public String delateById(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return "user deleted successfully in db";
	}
}
