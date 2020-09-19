package com.erhan.bestcommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="merchant_type")
public class MerchantType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "merchant_type_name")
    private String merchantTypeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantType")
    private Set<Merchant> users;

    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public String getMerchantTypeName() {
		return merchantTypeName;
	}

	public void setMerchantTypeName(String merchantTypeName) {
		this.merchantTypeName = merchantTypeName;
	}

	public void setUsers(Set<Merchant> users) {
		this.users = users;
	}

	public Set<Merchant> getUsers() {
		return users;
	}

	public void setMerchants(Set<Merchant> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "MerchantType [id=" + id + ", merchantTypeName=" + merchantTypeName + ", users=" + users + "]";
	}    

}
