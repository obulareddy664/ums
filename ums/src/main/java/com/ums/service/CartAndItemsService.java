package com.ums.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ums.entity.Cart;
import com.ums.entity.Items;
import com.ums.repository.CartRepository;
import com.ums.repository.ItemsRepository;

@Service
public class CartAndItemsService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Transactional
	public void saveCart(Cart cart,Set<Items> items) {
		cartRepository.save(cart);
		itemsRepository.saveAll(items);
		
	}
}
