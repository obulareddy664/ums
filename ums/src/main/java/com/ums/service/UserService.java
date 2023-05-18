package com.ums.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ums.UserException;
import com.ums.entity.UserCart;


public interface UserService {

	public Optional<UserCart> getById(Integer id)throws UserException;
}
