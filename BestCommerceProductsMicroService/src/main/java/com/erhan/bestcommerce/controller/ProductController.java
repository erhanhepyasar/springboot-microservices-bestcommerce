package com.erhan.bestcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erhan.bestcommerce.service.ProductService;

@RestController
@RequestMapping("/api/products2")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<?> findAllProducts() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}

}
