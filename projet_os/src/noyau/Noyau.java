package noyau;

import data.peripheral.Disk;
import data.peripheral.Keyboard;
import data.peripheral.Peripheral;
import data.peripheral.Screen;
import process.DiskPilote;
import process.EcranMgmt;

public class Noyau {

	public static void main(String[] args) {
		
		Peripheral keyboard = new Keyboard(1, "logi-toc");
		Screen ecran = new EcranMgmt(2, "fi lips");
		DiskPilote disk = new DiskPilote(3, "C"); 
		ecran.write(disk.getPath());
		ecran.write(disk.read());
		disk.write(" Test ");
		ecran.write(disk.read());
	}
}