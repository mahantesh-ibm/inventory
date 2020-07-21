package com.cts.ims.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ims.model.RawMaterial;
import com.cts.ims.repos.RawMaterialRepo;

@RestController
@RequestMapping("/rawmaterial")
public class RawMaterialController {

	@Autowired
	RawMaterialRepo repo;
	
	@RequestMapping(value="/getById/{id}", method = RequestMethod.GET)
	public RawMaterial getMaterialById(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public RawMaterial addMaterial(@RequestBody RawMaterial material) {
		return repo.save(material);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public RawMaterial updateMaterial(@RequestBody RawMaterial material) {
		return repo.save(material);
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.DELETE)
	public RawMaterial removeMaterial(@PathVariable("id") int id) {
		repo.deleteById(id);
		
		return new RawMaterial();
	}
	
}
