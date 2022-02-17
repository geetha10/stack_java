package com.art.exhibition;

public class Painting extends Art{
	
	String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		this.title=title;
		this.author=author;
		this.description=description;
		this.paintType = paintType;
	}


	

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	
}

