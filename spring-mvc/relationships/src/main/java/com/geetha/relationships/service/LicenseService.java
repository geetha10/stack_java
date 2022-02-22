package com.geetha.relationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.relationships.models.License;
import com.geetha.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	public List<License> allPersons(){
		return licenseRepository.findAll();
	}
	
	public License create(License license) {
		return licenseRepository.save(license);
	}

}
