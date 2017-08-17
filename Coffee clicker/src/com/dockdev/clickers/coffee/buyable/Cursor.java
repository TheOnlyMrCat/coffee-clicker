package com.dockdev.clickers.coffee.buyable;

import com.dockdev.clickers.coffee.Game;

public class Cursor extends Buyable {

	protected double mlps = 0.1;
	protected int multiplier = 0;
	private Game game;
	
	@Override
	public void tick() {
		game.mL+= 0.1;
	}

}
