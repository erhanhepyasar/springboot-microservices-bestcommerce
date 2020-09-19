package com.erhan.bestcommerce.service;

import java.util.List;
import java.util.Optional;

import com.erhan.bestcommerce.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);

}
