package hodilka.main;

import hodilka.InputOutputEngie;
import hodilka.input.InputSystem;
import hodilka.input.PlayerInput;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;
import hodilka.output.OutputSystem;

public class Application {
	
	public void execute() {
		
		// generate model
		ModelGenerator modelGenerator = new ModelGenerator();
		Model model = modelGenerator.createModel();
		
		// initialize input and output systems
		InputOutputEngie ioEngie = new InputOutputEngie(model);
		OutputSystem output = ioEngie.getOutputSystem();
		InputSystem input = ioEngie.getInputSystem();
		
		// initialize game logic
		LogicEngie logic = new LogicEngie(model);
		
		// game loop
		while (!logic.isDone()) {
			// render the model with all game objects
			output.render();
			
			// get input data from player
			PlayerInput playerInput = input.getUserInputWithWait();

			// change model state and state of game objects if needed
			logic.processInput(playerInput);
		}
		
	}

	@SuppressWarnings("unused")
	private synchronized void waitFor(long millis) {
		try {
			this.wait(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
