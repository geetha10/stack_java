package com.geetha.zookeeper;

public class Bat extends Mammal{
	
	public Bat() {
		super.energyLevel =300;
	}
	
	public void fly() {
		System.out.println("TakTakTak");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("so- well, never mind");
		energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("City On Fire");
		energyLevel -= 100;
	}
}
