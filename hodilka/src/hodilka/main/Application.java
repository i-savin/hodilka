package hodilka.main;

import hodilka.InputOutputEngie;
import hodilka.input.InputSystem;
import hodilka.input.PlayerKeyInput;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;
import hodilka.output.OutputSystem;

public class Application {
	
	private Model model;
	private InputOutputEngie ioEngine;
	private LogicEngine logic;
	private OutputSystem output;
	private InputSystem input;

	public Application() {
		// generate model
		ModelGenerator modelGenerator = new ModelGenerator();
		model = modelGenerator.createModel();
		
		// initialize input and output systems
		ioEngine = new InputOutputEngie(model);

		// initialize game logic
		logic = new LogicEngine(model);
		
		output = ioEngine.getOutputSystem();
		input = ioEngine.getInputSystem();
	}
	
	public void execute() {
		
		PlayerKeyInput playerInput = null;
		
		// game loop
		while (!logic.isDone()) {
			// render the model with all game objects
			output.render();
			
			// get input data from player
			playerInput = input.getUserInputNoWait();

			// change model state and state of game objects if needed
			logic.processInput(playerInput);
			
			waitFor(20);
		}
		
	}

	/** use to delay for UserInputNoWait*/
	private synchronized void waitFor(long millis) {
		try {
			this.wait(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
