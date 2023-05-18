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

import com.ums.UserException;
import com.ums.entity.UserCart;
import com.ums.model.UserStatus;
import com.ums.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<?> saveUser(@RequestBody UserCart user) {
		UserCart users=null;
		ResponseEntity<?> responseEntity = null;
		if(user.getUname()!=null && user.getUpassword()!=null) {
		users= userRepository.save(user);
		responseEntity=new ResponseEntity(users,HttpStatus.CREATED);
		}else {
			UserStatus userStatus = new UserStatus();
			userStatus.setCode("400");
			userStatus.setMessage("please provide user data correctly");
			userStatus.setType("Bad request");
			responseEntity = new ResponseEntity<>(userStatus, HttpStatus.BAD_REQUEST);
		}
		 return responseEntity;
	}

	@GetMapping
	public ResponseEntity<?> getAllUsers() {

		ResponseEntity<?> responseEntity = null;

		try {
			List<UserCart> userCarts = userRepository.findAll();
			if (userCarts == null || userCarts.isEmpty()) {
				UserStatus userStatus = new UserStatus();
				userStatus.setCode("400");
				userStatus.setMessage("there is no data present in the database for usercarts");
				userStatus.setType("Bad request");
				responseEntity = new ResponseEntity<>(userStatus, HttpStatus.BAD_REQUEST);
				return responseEntity;
			}
			responseEntity = new ResponseEntity(userCarts, HttpStatus.OK);
		} catch (Exception e) {
			UserStatus userStatus = new UserStatus();
			userStatus.setCode("500");
			userStatus.setMessage(e.getMessage());
			userStatus.setType("Internal ServerError");
			responseEntity = new ResponseEntity<>(userStatus, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {

		ResponseEntity<?> responseEntity = null;
		Optional<UserCart> user;
		if (id != 0) {
			try {
				user = userService.getById(id);
				responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
			} catch (UserException e) {
				UserStatus userStatus = new UserStatus();
				userStatus.setCode("400");
				userStatus.setMessage(e.getMessage());
				userStatus.setType("Bad request");
				responseEntity = new ResponseEntity<>(userStatus, HttpStatus.BAD_REQUEST);

			}
		} else {
			responseEntity = new ResponseEntity("the id is zero cannot be accepted send valid id" + id,
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public String delateById(@PathVariable Integer id) {
		userRepository.deleteById(id);
		return "user deleted successfully in db";
	}
}
