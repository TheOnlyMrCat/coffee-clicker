package com.dockdev.clickers.coffee.buyable;

import com.dockdev.clickers.coffee.Game;

public class Cursor extends Building {
	
	private Game game;

	private static double cost;
	
	public Cursor(Game game) {
		this.game = game;
	}
	
	@Override
	public void tick() {
		game.mL+= 0.1;
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getCost() {
		return cost;
	}

}
