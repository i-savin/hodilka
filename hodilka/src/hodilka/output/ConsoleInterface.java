package hodilka.output;

import hodilka.input.KeyInputSource;
import hodilka.model.Model;

public interface ConsoleInterface {
	void init();
	void clear();
	void flush();
	KeyInputSource getInputSource();
	void draw(Model model);
}
