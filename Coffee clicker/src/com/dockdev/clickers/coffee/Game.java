package com.dockdev.clickers.coffee;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dockdev.clickers.coffee.object.Config;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 8931882035223085907L;
	
	private static final int WIDTH = 640, HEIGHT = WIDTH;
	
	private Thread thread;
	private boolean running = false;
	private Window window;
	private Config config;
	
	private String version = "Alpha 1.0";

	public State menuState = State.GAME;
	
	public BufferedImage coffeemachine, coffeecup;
	
	public double mL = 0;
	
	public Game() {
		window = new Window(WIDTH, HEIGHT, "Coffee clicker " + version, this);
		
		try {
			coffeemachine = ImageIO.read(getClass().getResourceAsStream("/game/coffee-machine.png"));
			coffeecup = ImageIO.read(getClass().getResourceAsStream("/game/coffee-cup.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				 System.out.println("FPS: " + frames);
				frames = 0;
			}
			
			if (!window.isVisible()) {
				break;
			}
		}
		stop();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		switch (menuState) {
			case GAME: 
				g.drawImage(coffeemachine, 0, 0, null);
				break;
			default :
				break;
		}
		g.dispose();
		bs.show();
	}

	private void tick() {
		// TODO Auto-generated method stub
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		System.out.println("Started");
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Stopping!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		config.set("lastOffTime", String.valueOf(System.currentTimeMillis()));
		System.exit(0);
	}

}
