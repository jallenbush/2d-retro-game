package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		//returns key number action when pressed 
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP);{
			//W key moves character up
			upPressed = true;
		}
		if(code == KeyEvent.VK_DOWN);{
			//S key moves character up
			downPressed = true;
		}
		if(code == KeyEvent.VK_LEFT);{
			//A key moves character up
			leftPressed = true;
		}
		if(code == KeyEvent.VK_RIGHT);{
			//D key moves character up
			rightPressed = true;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//get key code
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP);{
			//W key moves character up
			upPressed = false;
		}
		if(code == KeyEvent.VK_DOWN);{
			//S key moves character up
			downPressed = false;
		}
		if(code == KeyEvent.VK_LEFT);{
			//A key moves character up
			leftPressed = false;
		}
		if(code == KeyEvent.VK_RIGHT);{
			//D key moves character up
			rightPressed = false;
		}	
	}

}
