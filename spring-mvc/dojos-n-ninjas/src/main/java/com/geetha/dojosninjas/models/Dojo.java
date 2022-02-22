package com.geetha.dojosninjas.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=50, message="Name of Dojo should be atleast 3 characters")
	private String dojoName;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated_at;
	
	@OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
	List<Ninja> ninjas;
	
	public Dojo() {
	}
	
	public Dojo(String dojoName) {
		this.dojoName = dojoName;
	}
	
	@PrePersist
	protected void oncreate() {
		this.created_at=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at= new Date();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDojoName() {
		return dojoName;
	}
	public void setDojoName(String dojoName) {
		this.dojoName = dojoName;
	}
	
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}

	
	
	
	
	
}
