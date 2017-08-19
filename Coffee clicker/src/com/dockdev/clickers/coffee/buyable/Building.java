package com.dockdev.clickers.coffee.buyable;

public abstract class Building extends Buyable {

	public abstract void tick();
	
	public abstract boolean onBuy(double cups);
}
