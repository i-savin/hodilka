package hodilka.output;

import hodilka.input.InputSource;
import hodilka.model.GameObjectRepresentation;

public interface ConsoleInterface {
	void init();
	void clear();
	void flush();
	int getWidhtInChars();
	int getHeightInChars();
	InputSource getInputSource();
	void draw(GameObjectRepresentation[][] modelRep);
}
