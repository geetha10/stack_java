package com.geetha.studentroster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geetha.studentroster.models.Dormitory;
import com.geetha.studentroster.models.Student;
import com.geetha.studentroster.repositories.DormRepository;
import com.geetha.studentroster.repositories.StudentRepository;

@Service
public class AppService {
	
	@Autowired
	DormRepository dormRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	//Students table related queries
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student saveNewStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id) {
		Optional<Student> student=	studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return null;
		}
	}
	

	
	//dorimitory table related queries
	public List<Dormitory> getAllDorms(){
		return dormRepository.findAll();
	}
	
	public Dormitory createNewDormitory(Dormitory dormitory) {
		return dormRepository.save(dormitory);
	}
	
	public List<Student> findStudentWithoutDorm(){
		return studentRepository.findByDormitoryIsNull();
	}
	
	public Dormitory getDormById(Long id) {
		Optional<Dormitory> dorm=	dormRepository.findById(id);
		if(dorm.isPresent()) {
			return dorm.get();
		}else {
			return null;
		}
	}
	
	
}
