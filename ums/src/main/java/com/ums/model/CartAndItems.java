package com.ums.model;

import java.util.Set;

import javax.persistence.OneToMany;

import com.ums.entity.Items;

import lombok.Data;

@Data
public class CartAndItems {

	private Integer cartId;

	
	private Set<Items> items;

	private String cartName;
}
