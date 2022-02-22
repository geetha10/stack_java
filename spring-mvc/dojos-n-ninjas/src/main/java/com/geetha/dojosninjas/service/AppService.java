package com.geetha.dojosninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.dojosninjas.models.Dojo;
import com.geetha.dojosninjas.models.Ninja;
import com.geetha.dojosninjas.repositories.DojoRepository;
import com.geetha.dojosninjas.repositories.NinjaRepository;

@Service
public class AppService {
	
	@Autowired
	private DojoRepository dojoRepo;
	@Autowired
	private NinjaRepository ninjaRepo;
	
	//ninja table operations
	public Ninja saveNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public Ninja updateNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	} 
	
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> ninja=ninjaRepo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	//dojo table operations
	public Dojo saveDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo=dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}else {
			return null;
		}
	}
}
