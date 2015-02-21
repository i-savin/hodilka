package hodilka.main;

import hodilka.input.PlayerInput;
import hodilka.logic.Controller;
import hodilka.model.Model;

public class LogicEngine {

	private Model model;
	private Controller controller;
	
	public LogicEngine(Model model) {
		this.model = model;
		controller = new Controller(model);
	}

	public void processInput(PlayerInput playerInput) {
		
		model.actualizeViewPortSize(playerInput.getActualWidthInPixels(), playerInput.getActualHeightInPixels());
		
		controller.nextState(playerInput);
		
		playerInput.cleanFlags();
	}

	public boolean isDone() {
		return false;
	}

}
