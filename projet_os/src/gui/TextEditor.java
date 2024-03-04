package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TextEditor extends JFrame {
	
	JScrollPane scrollPane;
	Cmd textArea;
	
	public TextEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("StrongShell");
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		this.textArea = new Cmd();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
	
		add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
	
	}
}













