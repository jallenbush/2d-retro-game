package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//character class
public class Entity {
	
	public int worldX, worldY;
	public int speed; 
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	//walking
	public int spriteCounter = 0;
	public int spriteNum = 1; 
	//player collison space setting
	public Rectangle solidArea;
	public boolean collisionOn = false; 
	
	
}
