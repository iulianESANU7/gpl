package frame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	MyFrame() {
		this.setTitle("Wow le titre inspire de fou !"); // sets title of this
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
															  // by default is HIDE_ON_CLOSE
		this.setResizable(false); // prevent this from be resized
		this.setSize(420, 420); // sets the x-dim & y-f=dim of the this
		this.setVisible(true); // make this visible
		
		ImageIcon logo = new ImageIcon("minecraftIcon.jpeg"); // create an imageicon
		this.setIconImage(logo.getImage()); // change icon of this
		this.getContentPane().setBackground(new Color(0x048b9a)); // change color of background
	}
}
