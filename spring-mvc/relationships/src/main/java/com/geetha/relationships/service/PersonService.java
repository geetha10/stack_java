package com.geetha.relationships.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.relationships.models.Person;
import com.geetha.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> potentialPerson= personRepository.findById(id);
		if(potentialPerson.isPresent()) {
			return potentialPerson.get();
		}else {
			return null;
		}
	}
	
	public Person savePerson(Person newPerson) {
		return personRepository.save(newPerson);
	}
	
	public Person updatePerson(Person newPerson) {
		return personRepository.save(newPerson);
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
