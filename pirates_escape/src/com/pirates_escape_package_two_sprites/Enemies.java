package com.pirates_escape_package_two_sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemies extends Sprite{
	
	public Enemies(int x , int speed) {
		w=80;
		h=80;
		this.x=x;
		this.speed = speed;
		y=40;
		image = new ImageIcon(Enemies.class.getResource("pngbomb.png"));
	}
	public void move() {
		if(y>600) {
			y = 0;
		}
		
		y = y + speed;
	}
	
	
}

