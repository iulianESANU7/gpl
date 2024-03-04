package frame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		/*
		JFrame frame = new JFrame(); // creates a frame
		frame.setTitle("Wow le titre inspire de fou !"); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
															  // by default is HIDE_ON_CLOSE
		frame.setResizable(false); // prevent frame from be resized
		frame.setSize(420, 420); // sets the x-dim & y-f=dim of the frame
		frame.setVisible(true); // make frame visible
		
		ImageIcon logo = new ImageIcon("minecraftIcon.jpeg"); // create an imageicon
		frame.setIconImage(logo.getImage()); // change icon of frame
		frame.getContentPane().setBackground(new Color(0x048b9a)); // change color of background
		*/
		
		// new MyFrame(); // if you don't plan to change the frame you can do this
		MyFrame myFrame = new MyFrame();
	}
	
}
