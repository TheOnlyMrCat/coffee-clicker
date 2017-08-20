package com.dockdev.clickers.coffee.buyable;

public abstract class Buyable {
	
	public abstract void tick();
	
	//Render in the menu
	public abstract void render();
	
	public abstract double getCost();
}
