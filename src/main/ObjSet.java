package main;

import object.ObjChest;
import object.ObjDoor;
import object.ObjectKey;

//allows for objects to be added to game
public class ObjSet {
	
	GamePanel gp;
	
	public ObjSet(GamePanel gp) {
		this.gp = gp;
	}
	//place objects on map
	public void setObject() {
		gp.obj[0] = new ObjectKey();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new ObjectKey();
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;
		
		gp.obj[2] = new ObjectKey();
		gp.obj[2].worldX = 37 * gp.tileSize;
		gp.obj[2].worldY = 7 * gp.tileSize;
		
		gp.obj[3] = new ObjDoor();
		gp.obj[3].worldX = 10 * gp.tileSize;
		gp.obj[3].worldY = 11 * gp.tileSize;
		
		gp.obj[4] = new ObjDoor();
		gp.obj[4].worldX = 8 * gp.tileSize;
		gp.obj[4].worldY = 28 * gp.tileSize;
		
		gp.obj[5] = new ObjDoor();
		gp.obj[5].worldX = 12 * gp.tileSize;
		gp.obj[5].worldY = 22 * gp.tileSize;
		
		gp.obj[6] = new ObjChest();
		gp.obj[6].worldX = 10 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;


	}
}
