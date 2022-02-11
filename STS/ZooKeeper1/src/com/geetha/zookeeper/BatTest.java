package com.geetha.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		
		Bat evilBat=new Bat();
		System.out.println(evilBat.displayEnergy());
		
		evilBat.attackTown();
		evilBat.attackTown();
		evilBat.attackTown();
		
		evilBat.eatHumans();
		evilBat.eatHumans();
		
		evilBat.fly();
		evilBat.fly();
		
		System.out.println(evilBat.displayEnergy());
	}

}
