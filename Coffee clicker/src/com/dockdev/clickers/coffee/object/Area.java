package com.dockdev.clickers.coffee.object;

import java.awt.Component;
import java.awt.Rectangle;

public class Area extends Component {

	private static final long serialVersionUID = 3047164380410065604L;

	private Component area;
	
	public Area(Rectangle r) {
		this(r.x, r.y, (int) r.getWidth(), (int) r.getHeight());
	}
	
	public Area(int x, int y, int width, int height) {
		area.setBounds(new Rectangle(x, y, width, height));
	}
	
	public void setMouseListener(MouseInput in) {
		area.addMouseListener(in);
	}
}
