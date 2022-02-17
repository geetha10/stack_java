package com.geetha.zookeeper;

public class Bat extends Mammal{
	
	public Bat() {
		super();
		super.energyLevel =300;
	}
	
	public void fly() {
		System.out.println("TakTakTak");
		super.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("so- well, never mind");
		super.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("City On Fire");
		super.energyLevel -= 100;
	}
}
