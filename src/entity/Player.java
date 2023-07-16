package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyControl;
 

public class Player extends Entity{
	
	GamePanel gp;
	KeyControl keyC; 
	
	public final int screenX;
	public final int screenY; 
	
	public Player(GamePanel gp, KeyControl keyC){
		
		this.gp = gp;
		this.keyC = keyC; 
		
		//screen position
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		//player collision settings; adjust as needed
		solidArea = new Rectangle();
		solidArea.x = 8; 
		solidArea.y = 16; 
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		//player position
		worldX = gp.tileSize *  23;
		worldY = gp.tileSize * 21;
		speed = 4; 
		direction = "down"; 
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-3.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-4.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-5.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-6.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-7.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/Boy-8.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyC.upPressed == true || keyC.downPressed == true || 
				keyC.leftPressed == true || keyC.rightPressed == true) {
			
			//player position
			if(keyC.upPressed == true) {
				direction = "up"; 	
			}
			else if(keyC.downPressed == true) {
				direction = "down";	
			}
			else if(keyC.leftPressed == true) {
				direction = "left";	
			}
			else if(keyC.rightPressed == true) {
				direction = "right";	
			}
			//check tile collision 
			collisionOn = false;
			gp.cCheck.checkTile(this); 
			
			//if collision false, player can move
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2; 
				}
				else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}	
	}
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1; 
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1; 
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
	

}
