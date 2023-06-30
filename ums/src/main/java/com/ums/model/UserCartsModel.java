package com.ums.model;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ums.entity.UserCart;

import lombok.Data;

@Data
public class UserCartsModel {

	private Integer size;
	
	private Page<UserCart> userCarts;
}
