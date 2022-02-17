package com.art.exhibition;

public class Sculpture extends Art{
	
	String material;

	public Sculpture(String title, String author, String description, String material) {
		this.title=title;
		this.author=author;
		this.description=description;
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}	

}
