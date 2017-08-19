package com.dockdev.clickers.coffee;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = 3813043690020261279L;

	private JFrame frame;
	public Window(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                game.stop();
            }
        });
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	public boolean isVisible() {
		return frame.isVisible();
	}
}
