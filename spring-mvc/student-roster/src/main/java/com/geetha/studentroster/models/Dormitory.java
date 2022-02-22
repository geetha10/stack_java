package com.geetha.studentroster.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dormitories")
public class Dormitory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min= 3, max= 100, message="Dorimotory name should be at least 3 characters")
	private String dormName;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;	
	
	@OneToMany(mappedBy = "dormitory", fetch = FetchType.LAZY)
	private List<Student> students;
	
	public Dormitory() {
		
	}
	
	public Dormitory(String dormName) {
		this.dormName=dormName;
	}
	
	public Long getId() {
		return id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	
	@PrePersist
	protected void oncreate() {
		this.created_at=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at= new Date();
	}
}
