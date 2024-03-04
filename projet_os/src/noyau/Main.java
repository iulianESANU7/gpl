package noyau;

import javax.swing.SwingUtilities;

import gui.TextEditor;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextEditor();
			}
		});
	}
}
