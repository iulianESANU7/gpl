package noyau;

import data.peripheral.Keyboard;
import data.peripheral.Peripheral;
import process.EcranMgmt;

public class Noyau {

	public static void main(String[] args) {
		
		Peripheral keyboard = new Keyboard(1, "logi-toc");
		Peripheral ecran = new EcranMgmt(2, "fi lips");
		ecran.write("blabla");
	}
}
