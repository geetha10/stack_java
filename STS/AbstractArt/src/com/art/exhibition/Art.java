package com.art.exhibition;

public abstract class Art {
	
    String title;
	String author;
    String description;
    
    public Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
    
    public void viewArt() {
    	System.out.println("Tile of art is "+ title+" Author is "
    						+author+" description "+description);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
