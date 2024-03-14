package process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.peripheral.Disk;
import data.peripheral.Pilote;

public class DiskPilote implements Pilote {

	Disk disk;
	
	public DiskPilote(int id, String name) {
		disk = new Disk(id, name);
	}
	
	public String read() {
		return disk.getPath();
	}

	public void write(String content) {

	}

	
}
