package com.erhan.bestcommerce.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.erhan.bestcommerce.entity.Merchant;

@CrossOrigin
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
	
	Page<Merchant> findByMerchantTypeId(@RequestParam("id") Long id, Pageable pageable);
	Optional<Merchant> findByMerchantName(@RequestParam("name") String name);
	
}
