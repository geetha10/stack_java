package com.geetha.zookeeper;

public class GorillaTest {
	public static void main(String[] args){
		Gorilla cuteGorilla= new Gorilla();
		
		cuteGorilla.throwSomething();
		cuteGorilla.throwSomething();
		cuteGorilla.throwSomething();
		
		cuteGorilla.eatBananas();
		cuteGorilla.eatBananas();
		
		cuteGorilla.climb();
		
		System.out.println(cuteGorilla.displayEnergy());
	}
}
