package process;

import javax.swing.SwingUtilities;

import data.peripheral.Ecran;
import data.sys.TextBloc;
import gui.TextEditor;

public class EcranMgmt extends Ecran{

	public EcranMgmt(int id, String name) {
		super(id, name);
		run();
	}
	
	private void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ecran = new TextEditor();
			}
		});
	}
	
	@Override
	public String write(String content) { // probleme sur cette methode et ce qui en decoule.
			ecran.append(content);
		return null;
	}
}