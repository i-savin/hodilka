package hodilka.output;

import hodilka.model.Model;

public class OutputSystem {
	
	private OutputInterface consoleInterface;
	private Model model;
	private long lastRendered;
	
	public OutputSystem(OutputInterface consoleInterface, Model model) {
		this.consoleInterface = consoleInterface;
		this.model = model;
		lastRendered = System.currentTimeMillis();
	}
	
	public void render() {
		if (System.currentTimeMillis() - lastRendered > 30) {
			
			consoleInterface.clear();
			
			consoleInterface.draw();
			
			consoleInterface.flush();
			
			lastRendered = System.currentTimeMillis();
		}
	}
}
