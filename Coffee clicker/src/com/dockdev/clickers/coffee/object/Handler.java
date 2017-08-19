package com.dockdev.clickers.coffee.object;

import java.util.LinkedList;

import com.dockdev.clickers.coffee.buyable.Building;

public class Handler {

	public LinkedList<Building> building = new LinkedList<Building>();
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.tick();
		}
		for (int i = 0; i < building.size(); i++) {
			Building tempBuilding = building.get(i);
			
			tempBuilding.tick();
		}
	}
}
