package com.pirates_escape_package_one;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.pirates_escape_package_two_sprites.Enemies;
import com.pirates_escape_package_two_sprites.PauseOverlay;
import com.pirates_escape_package_two_sprites.Player;


public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	Enemies enemies[] = new Enemies[3];
	PauseOverlay  pauseOverlay;
	private boolean setPause;
	
public Board() {
	
	setSize(900,600);
	loadBackgroundImage();
	player = new Player();
	loadEnemies();
	gameloop(false);
	pauseOverlay = new PauseOverlay();
	bindEvents();
	setFocusable(true);
	addMouseListener(new PauseOverlay() );
	
}

private void gameOver(Graphics pen) {
	if(player.outOfScreen()) {
		pen.setFont(new Font("times", Font.BOLD , 60));
		pen.setColor(Color.GREEN);
		pen.drawString("GAME WIN", 900/3, 600/3);
		timer.stop();
	}
	for(Enemies enemies : enemies) {
		if(isCollide(enemies)) {
			pen.setFont(new Font("times", Font.BOLD , 60));
			pen.setColor(Color.RED);
			pen.drawString("GAME OVER", 900/3, 600/3);
			timer.stop();
		}
	}
}

private boolean isCollide(Enemies enemies) {
	
	int xDistance = Math.abs(player.x - enemies.x);
	int yDistance = Math.abs(player.y - enemies.y);
	int maxH = Math.max( player.h, enemies.h );
	int maxW = Math.max( player.w, enemies.w );
	return xDistance <= maxH-90 && yDistance <=maxW-90;
}

private void bindEvents() {
	addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.speed = 0;
			player.jumpup = 0;
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.speed = 7;}
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.speed = -7;}
			
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					player.jumpup = -7;}
					
					if(e.getKeyCode() == KeyEvent.VK_DOWN) {
						player.jumpup = +7;}

		}
	});

	}


private void loadEnemies() {
	int x = 230;
	int gap = 250;
	int speed = 5;
	for(int i = 0; i<enemies.length ; i++) {
		enemies[i] = new Enemies(x , speed);
		x = x + gap;
		speed = speed + 5;
	}
		
}


public void setGamePause(boolean setPause) {
	this.setPause = setPause;
	gameloop(setPause);
}


	public void gameloop(boolean setPause) {
			if(!setPause) {
		timer = new Timer(50,(e)->repaint());
	timer.start();		}
			

		
		
	
}
private void loadBackgroundImage()  {
	
	try {
	backgroundImage = ImageIO.read(Board.class.getResource("badiyawalabackground.jpg"));
	}
	catch (IOException e) {
		System.out.println("BACKGROUND IMAGE NOT FOUND");
		System.exit(1);
		e.printStackTrace();
	}
}

private void printEnemies(Graphics pen) {
	if(!setPause) 
	{
	for(Enemies enemies : enemies) {
		enemies.draw(pen);
		enemies.move();
	}}
}

public void paintComponent(Graphics pen) {
	super.paintComponent(pen);//clean up and all the printing logic will be build by the paint component 
   pen.drawImage(backgroundImage, 0 , 0 , 900 ,600 , null);
   player.draw(pen);
   player.moveside();
   player.moveup();
   player.movedown(); 
   printEnemies(pen);
   gameOver(pen);
   pauseOverlay.draw(pen);
}




}














//asd
