package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjSock extends SuperObject {
	
	public ObjSock() {
		
		name = "Sock";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/sock.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


}
