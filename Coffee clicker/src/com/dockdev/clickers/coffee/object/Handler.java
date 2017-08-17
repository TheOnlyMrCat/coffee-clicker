package com.dockdev.clickers.coffee.object;

import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
