package com.pirates_escape_package_two_sprites;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import com.pirates_escape_package_one.Board;


public class PauseOverlay extends Sprite implements MouseListener {
	private Board board;
	
  public PauseOverlay() {
	  w=60;
		h=50;
		x=40;
		y=30;
	  image = new ImageIcon(PauseOverlay.class.getResource("pause.png"));
	  
  }

@Override
public void mouseClicked(MouseEvent e) {
	if(e.getButton() == MouseEvent.BUTTON1) {
		setPause(false);	
	}
}

private void setPause(boolean setPause) {
board.setGamePause(setPause);
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
  

