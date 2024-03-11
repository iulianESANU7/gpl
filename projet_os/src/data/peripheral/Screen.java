package data.peripheral;

import javax.swing.SwingUtilities;

import gui.TextEditor;

public class Screen extends Peripheral{
	
	public TextEditor ecran;
	
	public Screen(int id, String name) {
		this.id = id;
		this.name = name;
		ecran = new TextEditor();
	}
	
	/*
	 * Pour le futur, il faudra voir les informations qu'un ecran est susceptible de renvoyer
	 * vers le pc.
	 */
	public String read() {
		return null;
	}

	/*
	 * Ca va etre la fonction d'affichage.
	 * Elle prend un TextBloc et l'affiche a l'ecran.
	 */
	public void write(String content) {
		ecran.append(content);
	}
}
