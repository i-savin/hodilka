package hodilka.output;

import hodilka.input.InputSource;
import hodilka.model.Model;

public interface OutputInterface {
	void init(Model model);
	void clear();
	void flush();
	InputSource getInputSource();
	void draw();
}
