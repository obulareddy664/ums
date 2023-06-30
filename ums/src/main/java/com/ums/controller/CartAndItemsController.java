package com.ums.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ums.entity.Cart;
import com.ums.entity.Items;
import com.ums.model.CartAndItems;
import com.ums.service.CartAndItemsService;

@RestController
@RequestMapping("/cartanditems")
public class CartAndItemsController {

	@Autowired
	private CartAndItemsService cartAndItemsService;
	
	@PostMapping
	public ResponseEntity saveCart(@RequestBody CartAndItems cartAndItems){
		
		Cart cart=new Cart();
		cart.setCartId(cartAndItems.getCartId());
		cart.setCartName(cartAndItems.getCartName());
		
		Set<Items> items=cartAndItems.getItems();
		cartAndItemsService.saveCart(cart, items);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
