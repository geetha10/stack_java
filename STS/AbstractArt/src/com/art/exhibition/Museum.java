package com.art.exhibition;

import java.util.ArrayList;

public class Museum {
	public static void main(String[] args) {
		
		ArrayList<Art> museum = new ArrayList<Art> ();
		
		Painting p1=new Painting("Abstract art1", "Geetha", "This is a abstract art1","Oil painting");
		Painting p2=new Painting("Abstract art2", "Geetha", "This is a abstract art2","Oil painting");
		Painting p3=new Painting("Abstract art3", "Geetha", "This is a abstract art3","Oil painting");
		Sculpture s1= new Sculpture("Abstract art4", "Geetha", "This is a abstract art4","clay");
		Sculpture s2= new Sculpture("Abstract art5", "Geetha", "This is a abstract art5","clay");
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
		for(Art art: museum){
			art.viewArt();
		}
	}
}
