package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	//game screen settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3; 
	public final int tileSize = originalTileSize * scale; //48x48 tile
	//screen size
	public final int maxScreenCol = 16; 
	public final int maxScreenRow = 12; 
	public final int screenWidth = tileSize * maxScreenCol; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//world settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this); 
	
	//add KeyControl to game
	KeyControl keyC = new KeyControl();
	//game clock //thread used to run until stop
	Thread gameThread;
	public CollisionCheck cCheck = new CollisionCheck(this);
	public ObjSet oSet = new ObjSet(this); 
	public Player player = new Player(this, keyC);
	
	//prepare slots for objects
	public SuperObject obj[] = new SuperObject[10];
	
	
	//game panel constructor
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.yellow);
		this.setDoubleBuffered(true); //improves rendering performance
		this.addKeyListener(keyC); //reorganize key input
		this.setFocusable(true);
	}
	public void setObGame() {
		oSet.setObject();
	}
	public void startGameThread() {
		//game start
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval; 
			timer += (currentTime - lastTime); 
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++; 
			}
			if(timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
	}
	//update FPS
	public void update() {
		player.update();
	}
	
	//built-in draw tool in JPanel 
	//Graphics like paint brush 
	public void paintComponent(Graphics g) {
		
		//parent graph of graph
		super.paintComponent(g);
				
		Graphics2D g2 = (Graphics2D)g;
		
		//draw tiles before player
		tileM.draw(g2);
		
		//draw objects
		for(int i = 0; i < obj.length; i++) {
			//check for null pointer error
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//player
		player.draw(g2);
		
		//save memory
		g2.dispose();
	}
}
		


