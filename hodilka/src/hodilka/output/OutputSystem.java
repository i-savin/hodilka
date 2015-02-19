package hodilka.output;

import hodilka.model.Model;

public class OutputSystem {
	
	private ConsoleInterface consoleInterface;
	private Model model;
	
	public OutputSystem(ConsoleInterface consoleInterface, Model model) {
		this.consoleInterface = consoleInterface;
		this.model = model;
	}
	
	public void render() {
		consoleInterface.clear();
		
		consoleInterface.draw(model);
		
		consoleInterface.flush();
	}
}
