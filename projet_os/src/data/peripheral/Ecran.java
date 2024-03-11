package data.peripheral;

import javax.swing.SwingUtilities;

import gui.TextEditor;

public class Ecran extends Peripheral{
	
	protected TextEditor ecran;
	
	public Ecran(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/*
	 * Pour le futur, il faudra voir les informations qu'un ecran est susceptible de renvoyer
	 * vers le pc.
	 */
	@Override
	public String read() {
		return null;
	}
	
	

	/*
	 * Ca va etre la fonction d'affichage.
	 * Elle prend un TextBloc et l'affiche a l'ecran.
	 */
	@Override
	public String write(String a) {
		
		return null;
	}
}
