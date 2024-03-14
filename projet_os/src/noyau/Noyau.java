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
		Screen screen = new EcranMgmt(2, "fi lips");
		
		DiskPilote disk = new DiskPilote(3, "Test");
		screen.write(disk.read());
		
		DiskPilote disk2 = new DiskPilote(4, disk.read() + "alors");
		screen.write(disk2.read());
	}
}