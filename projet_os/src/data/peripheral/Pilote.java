package data.peripheral;

import data.sys.TextBloc;

public interface Pilote {
	public String read();
	public void write(String content);
}
