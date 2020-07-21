package com.cts.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ims.model.RawMaterial;

public interface RawMaterialRepo extends JpaRepository<RawMaterial, Integer> {
	
	RawMaterial findByIteamName(String iteamName);
	RawMaterial findById(int id);
	

}
