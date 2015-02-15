package hodilka.output;

import hodilka.input.InputSource;

import java.awt.Color;

public interface ConsoleInterface {
	void init();
	void print(int i, int j, char what);
	void print(int i, int j, char what, Color foreground);
	void print(int i, int j, char what, Color foreground, Color background);
	void clear();
	void flush();
	int getWidhtInChars();
	int getHeightInChars();
	InputSource getInputSource();
}
