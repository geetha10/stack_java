package com.art.exhibition;

public class Painting extends Art{
	
	public Painting(String title, String author, String description) {
		super(title, author, description);
		// TODO Auto-generated constructor stub
	}
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}


	String paintType;

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	
}

