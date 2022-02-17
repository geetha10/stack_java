package com.heidichen.firstmvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.heidichen.firstmvcdemo.models.Icecream;

public interface IcecreamRepository extends CrudRepository<Icecream, Long> {
	
	List<Icecream> findAll();
	

}
