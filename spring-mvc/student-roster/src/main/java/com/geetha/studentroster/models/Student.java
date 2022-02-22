package com.geetha.studentroster.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3, max =45, message="First Name should be min of 3 characters")
	private String firstName;
	
	@NotEmpty
	@Size(min=3, max =45, message="Last Name should be min of 3 characters")
	private String lastName;

	@Min(value = 20)
	private Integer age;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creted_at;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dormitory_id")
	private Dormitory dormitory;
	
	public Student() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastName;
	}

	public void setLastNAme(String lastNAme) {
		this.lastName = lastNAme;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Dormitory getDormitory() {
		return dormitory;
	}

	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
	}

	@PrePersist
	public void onCreate() {
		this.creted_at=new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_at=new Date();
	}

}
