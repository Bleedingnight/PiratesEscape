package com.pirates_escape_package_one;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	public GameFrame() {
		Board board = new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pirates_Escape");
		this.setSize(900,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		add(board);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame();
		
	}

}
