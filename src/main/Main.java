package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		//window frame
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("The Adventures of Ninja Boy");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();
		
		//window position
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		//setup objects in game
		gamePanel.setObGame();
		
		//starts running game
		gamePanel.startGameThread();
		
	}

}
