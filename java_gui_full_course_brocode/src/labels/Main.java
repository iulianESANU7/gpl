package labels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main {

	public static void main(String[] args) {
		
		ImageIcon image = new ImageIcon("18.jpg");
		Border border = BorderFactory.createLineBorder(new Color(0x483248), 7); //create a border
		
		JLabel label = new JLabel(); // create a label
		label.setText("Bro do you even lift ?"); // set text of label
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of ImageIcon
		label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER or BOTTOM of ImageIcon
		label.setForeground(new Color(0x048b9a)); // set font color of text 
		label.setFont(new Font("MV Boli", Font.PLAIN, 50)); // set font of text
		label.setIconTextGap(15); // set gap of text to image
		label.setBackground(Color.black); // set background color
		label.setOpaque(true); // display background color
		label.setBorder(border); // set the border
		label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within the label
		label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within the label
		// label.setBounds(100, 100, 250, 250); // set x, y position within frame as well as dimention
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(500, 500);
		// frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		frame.pack(); // ajust to accomodate size label with the window size
	}
 
}
