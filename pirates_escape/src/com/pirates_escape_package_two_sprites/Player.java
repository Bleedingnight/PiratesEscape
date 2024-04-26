package com.pirates_escape_package_two_sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {
	
	public Player() {
		
		w=150;
		h=150;
		x=50;
		y=370;
		image = new ImageIcon(Player.class.getResource("player.gif"));
	}
	
	public void moveside() {
		x = x + speed; 
	}
	
	public void moveup() {
		y = y + jumpup;
	}
	
	public void movedown() {
		y = y - jumpdown;
	}
	
	
	
	public boolean outOfScreen() {
		return x>900;
	}
}
