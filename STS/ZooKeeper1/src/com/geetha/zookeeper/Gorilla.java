package com.geetha.zookeeper;

public class Gorilla extends Mammal{
	
	public void throwSomething(){
		System.out.println("Gorilla has trown a object.");
		super.energyLevel -= 5;
	}
	
	public void eatBananas(){
		System.out.println("Gorilla ate banana");
		super.energyLevel += 10;
	}
	
	public void climb(){
		System.out.println("Gorilla has climbed a tree");
		super.energyLevel -= 10;
	}

}
// throwSomething(), eatBananas(), and climb()