package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.main.entity.Cart;
import com.spring.main.repository.CartRepository;
import com.spring.main.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepository cartRepository;
	
	@PostMapping("/post")
	public Cart post(@RequestBody Cart cart) {
		return cartService.post(cart);
	}
	
	@GetMapping("/get/{id}")
	public Cart getById(@PathVariable int id) {
		return cartService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<Cart> getAll() {
		return cartService.getAll();
	}
	
//	@PutMapping("/update")
//	public Cart update(@RequestBody Cart cart) {
//		return applicantService.update(cart);
//	}
	
	@PutMapping("/update/{id}")
	Cart update(@RequestBody Cart cart, @PathVariable int id) {
        return cartRepository.findById(id)
                .map(caRT -> {
                	caRT.setCourseCname(caRT.getCourseCname());
                	caRT.setCourseCuploadDate(caRT.getCourseCuploadDate());
                	caRT.setCourseCarticle(cart.getCourseCarticle());
                    return cartRepository.save(caRT);
                })
                .orElseGet(() -> {
                	cart.setCart_id(id);
                    return cartRepository.save(cart);
                });
    }
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return cartService.delete(id);
	}
	
	@PostMapping("/postall")
	public List<Cart> postAll(@RequestBody List<Cart> list) {
		return cartService.postAll(list);
	}
}
