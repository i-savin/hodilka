package hodilka.main;

import hodilka.InputOutputEngie;
import hodilka.input.UserInput;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;

public class Application {
	
	public void execute() {
		
		ModelGenerator modelGenerator = new ModelGenerator();
		
		Model model = modelGenerator.createModel();
		
		InputOutputEngie ioEngie = new InputOutputEngie(model);
		
		LogicEngie logic = new LogicEngie(model);
		
		// Game loop
		while (!logic.isDone()) {
			// render the model with all game objects
			ioEngie.render();
			
			// get input data from player
			UserInput userInput = ioEngie.getInputSystem().getInputWithWait();

			// change model state
			logic.processInput(userInput);
		}
		
	}

	@SuppressWarnings("unused")
	private synchronized void waitFor(long milis) {
		try {
			this.wait(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
