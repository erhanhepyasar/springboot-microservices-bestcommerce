package com.erhan.bestcommerce.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.erhan.bestcommerce.entity.Role;
import com.erhan.bestcommerce.entity.User;

public class UserServiceImplTest {
	
	@Test
    public void saveUser(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user = new User();
		user.setUsername("test username");
		user.setName("test name");
		user.setPassword("test password");
		user.setRole(Role.USER);
		user.setToken("test token");
		
		assertNotNull(userServiceImpl.saveUser(user));
    }
	
	@Test
    public void updateUser(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user = new User();
		user.setUsername("test username");
		user.setName("test name");
		user.setPassword("test password");
		user.setRole(Role.USER);
		user.setToken("test token");
		
		assertNotNull(userServiceImpl.updateUser(user));		
    }
	
	@Test
    public void deleteUser(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
        		
		userServiceImpl.deleteUser(1L);
    }
	
	@Test
    public void findByUsername(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		assertNotNull(userServiceImpl.findByUsername("User-1"));
    }
	
	@Test
    public void findAllUsers(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		assertNotNull(userServiceImpl.findAllUsers());
    }
	
	@Test
    public void numberOfUsers(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		assertNotNull(userServiceImpl.numberOfUsers());
    }


}
