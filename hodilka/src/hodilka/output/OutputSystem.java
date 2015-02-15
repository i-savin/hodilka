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
		
		char[][] modelRep = model.getReprezentation();
		
		for (int i = 0; i < modelRep.length; i++) {
			for (int j = 0; j < modelRep[i].length; j++) {
				consoleInterface.print(i, j, modelRep[i][j]);
			}
		}
		
		consoleInterface.flush();
	}
}
