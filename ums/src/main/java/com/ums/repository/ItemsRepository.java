package com.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ums.entity.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
