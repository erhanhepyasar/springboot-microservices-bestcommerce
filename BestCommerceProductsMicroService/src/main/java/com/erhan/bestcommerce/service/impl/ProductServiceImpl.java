package com.erhan.bestcommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erhan.bestcommerce.entity.Product;
import com.erhan.bestcommerce.repo.ProductRepository;
import com.erhan.bestcommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {

		return productRepository.findById(id);
	}

}
