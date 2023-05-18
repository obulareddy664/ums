package com.ums.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ums.entity.UserCart;



@Repository
public interface UserRepository extends JpaRepository<UserCart, Integer>{

	
}
