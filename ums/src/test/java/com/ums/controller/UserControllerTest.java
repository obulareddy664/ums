package com.ums.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ums.UserException;
import com.ums.entity.UserCart;
import com.ums.repository.UserRepository;
import com.ums.service.UserService;
//UserControllerTest
@SpringBootTest
 class UserControllerTest {

	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;

	
	@Test
	 void testSaveUser() {
		
		UserCart userCart=new UserCart();
	ResponseEntity responseEntity=	userController.saveUser(userCart);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}
	
	@Test
	 void testSaveUserOne() {
		
		UserCart userCart=new UserCart();
		userCart.setUname("name");
		userCart.setUpassword("name");
	ResponseEntity responseEntity=	userController.saveUser(userCart);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}
	
	@Test
	 void testGetById() throws UserException {
	
		when(userService.getById(1)).thenThrow(UserException.class);
		ResponseEntity responseEntity=	userController.getById(1);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
		
	}
	
	@Test
	 void testGetByIdOne() throws UserException {
	
		ResponseEntity responseEntity=	userController.getById(1);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
	 void testGetByIdTwo() throws UserException {
	
		ResponseEntity responseEntity=	userController.getById(0);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
	}
}
