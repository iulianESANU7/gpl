package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Cmd extends JTextArea{
	
	public Cmd() {
		setLineWrap(true);
		setWrapStyleWord(true);
		setFont(new Font("Consolas", Font.PLAIN, 20));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
		setCaret(new CustomCaret());
		setEditable(false);
	}
}




