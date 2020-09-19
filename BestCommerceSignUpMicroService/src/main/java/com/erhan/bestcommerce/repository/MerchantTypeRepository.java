package com.erhan.bestcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.erhan.bestcommerce.entity.MerchantType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "merchant_type", path = "merchant-type")
public interface MerchantTypeRepository extends JpaRepository<MerchantType, Long> {

}
