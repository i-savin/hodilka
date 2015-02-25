package hodilka.main;

import hodilka.InputOutputEngie;
import hodilka.input.InputSystem;
import hodilka.input.PlayerInput;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;
import hodilka.output.OutputSystem;

public class Application {
	
	private Model model;
	private InputOutputEngie ioEngine;
	private LogicEngine logic;
	private OutputSystem output;
	private InputSystem input;
	
	private long markedTIme;
	private long timeToWait = 20;

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
		
		PlayerInput playerInput = null;
		
		// game loop
		while (!logic.isDone()) {
			
			markTime();
			
			// render the model with all game objects
			output.render();
			
			// get input data from player
			playerInput = input.getUserInputNoWait();
			
//			if (!playerInput.isEmpty()) {
//				System.out.println(playerInput);
//			}

			// change model state and state of game objects if needed
			logic.processInput(playerInput);
			
			waitFor(timeToWait);
		}
		
	}

	private long timeElipsed(long delta) {
		return delta - System.currentTimeMillis() + markedTIme;
	}

	private void markTime() {
		markedTIme = System.currentTimeMillis();
	}

	/** use to delay */
	private synchronized void waitFor(long millis) {
		try {
			long t = timeElipsed(millis);
			if (t > 0)
				// synchronized on this
				this.wait(t);
			else
				;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
