package com.ums.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ums.entity.UserCart;

@Repository
public interface UserRepository extends JpaRepository<UserCart, Integer> {

	
	@Modifying
	@Transactional
	@Query(value="update user_cart uc SET uc.uname= :uname WHERE uc.uid = :uid",nativeQuery=true)
	public void updateUserUsingQueryAnnotation(@Param("uname") String uname, @Param("uid") Integer uid);
	
	
	
	
	
	
	
	
}
