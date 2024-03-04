package data;

public class Processus implements Runnable{
	private int id; 
	private String nom;
	private Thread thread;
	
	public Processus(int id, String nom) {
		this.id = id;
		this.nom = nom;
		this.thread = new Thread(this, nom);
	}
	
	public void start() {
		this.thread.start();
	}

	@Override
	public void run() {
		// code a executer, temp a voir en fonction de l'evolution du projet.
	}
	
	public String[] identify() {
		String[] r = new String[2];
		
		r[0] = this.nom;
		r[1] = this.id + "";
		
		return r;
	}
}
