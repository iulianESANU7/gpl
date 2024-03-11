package data.peripheral;

public class Mouse extends Peripheral {

	private int x;
	private int y;
	
	/*
	 * A finir une fois que l'ecran sera totalement mis en place.
	 * La souris demandera a chaque cycle ses coordonnes a l'ecran, 
	 * et si read() est appele, la methode renvera ses coordonnees.
	 * 
	 * Ou alors on implemente juste un systeme de clique unique (pas de distinction
	 * droite, gauche, ...)
	 * 
	 * Bref a voir en fonction de quelle direction prend le projet,
	 * si on fait quelque chose de full keyboard ou non.
	 */
	
	public String read() {
		String coord = new String(this.x + "," + this.y);
		return coord;
	}
	
}
