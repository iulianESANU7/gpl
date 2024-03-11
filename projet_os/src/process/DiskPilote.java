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
		StringBuilder fContent = new StringBuilder();
		File file = new File(disk.name + ".txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
			String line;
			while ((line = reader.readLine()) != null) {
				fContent.append(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fContent.toString();
	}

	public void write(String content) {
	    File file = new File(disk.name + ".txt");
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
	        writer.write(content);
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public String getPath() {
		return disk.name + ":\\ >";
	}

}
