package com.art.exhibition;

public abstract class Art {
	
    protected String title;
    protected String author;
    protected String description;
    
    public void viewArt() {
    	System.out.println("Tile of art is "+ title+" Author is "
    						+author+" description "+description);
    }


}
