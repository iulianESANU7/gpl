package data.peripheral;

import java.io.File;

public class Disk extends Peripheral {
	private File dir;
	
	public Disk(int id, String name) {
		this.id = id;
		this.name = name;
		this.dir = new File(this.name);
		
		if (!this.dir.exists()) {
			try {
				this.dir.mkdir();
			} catch(Exception e) {
				System.out.println("Erreur creation dossier : " + e.getMessage());
			}
		}
	}

	public String getPath() {
		return this.dir.getPath();
	}
}