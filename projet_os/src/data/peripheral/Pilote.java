package data.peripheral;

import data.sys.TextBloc;

public interface Pilote {
	public String read();
	public String write(String content);
}
