package hodilka.main;

import hodilka.InputOutputEngie;
import hodilka.input.InputSystem;
import hodilka.input.PlayerInput;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;
import hodilka.output.OutputSystem;

public class Application {
	
	private ModelGenerator modelGenerator;
	private Model model;
	private InputOutputEngie ioEngie;
	private LogicEngie logic;

	public Application() {
		// generate model
		modelGenerator = new ModelGenerator();
		model = modelGenerator.createModel();
		
		// initialize input and output systems
		ioEngie = new InputOutputEngie(model);

		// initialize game logic
		logic = new LogicEngie(model);
	}
	
	public void execute() {
				
		OutputSystem output = ioEngie.getOutputSystem();
		InputSystem input = ioEngie.getInputSystem();
		
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

	/** use to delay for UserInputNoWait*/
	@SuppressWarnings("unused")
	private synchronized void waitFor(long millis) {
		try {
			this.wait(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
