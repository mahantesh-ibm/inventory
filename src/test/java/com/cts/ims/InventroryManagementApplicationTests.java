package com.cts.ims;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.ims.model.RawMaterial;
import com.cts.ims.model.User;
import com.cts.ims.repos.RawMaterialRepo;
import com.cts.ims.repos.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class InventroryManagementApplicationTests {

	@Autowired
	RawMaterialRepo repo;
	
	@Autowired
	UserRepo userRepo;
	
	@Test
	public void contextLoad() {
		
	}
	
	@Test
	public void testCreateMaterial() {
		RawMaterial material=new RawMaterial();
		material.setId(3);
		material.setIteamName("pipe");
		material.setType("pastic");
		material.setQuantity(1000);
		material.setPricePerPiece(1d);
		repo.save(material);
	}
	
	@Test
	public void testUpdateMaterial() {
		RawMaterial material=repo.findByIteamName("pipe");
		material.setQuantity(100);
		repo.save(material);
	}
	
	@Test
	public void testDeleteMaterial() {
		repo.deleteById(3);
	}
	
	
	@Test
	public void testAddUser() {
		User user=new User();
		user.setId(13);
		user.setFirstName("Mahant");
		user.setLastName("M");
		user.setEmailId("xyz@gmail.com");
		userRepo.save(user);
	}
	
	@Test
	public void getUserById() {
		User user= userRepo.findById(13);
		assertNotNull(user);
		assertEquals("Mahant", user.getFirstName());
	}
}
