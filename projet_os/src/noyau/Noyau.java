package noyau;

import data.Processuses;

public class Noyau {
	private Processuses taskManager; // a voir si on
											 // on devrait pas plutot faire une
											 // class directement.
	
	public Noyau() {
		this.taskManager = Processuses.getInstance();
	}
}
