package data.peripheral;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Disk extends Peripheral {
	
	public Disk(int id, String name) {
		this.id = id;
		this.name = name;
		
		// creation dossier si name inexistant.
	}
}