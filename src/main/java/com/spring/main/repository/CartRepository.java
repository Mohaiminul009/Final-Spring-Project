package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
