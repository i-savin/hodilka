package hodilka.logic;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public class Controller {
//	private ControllerState state = new ControllerStateInitial();
	private ControllerState state = new ControllerStateMain();
	private Model model;
	
	public Controller(Model model) {
		this.model = model;
	}

	public boolean isDone() {
		return state.isFinalState();
	}

	public void nextState(PlayerInput playerInput) {
		state.perform(model, playerInput);
		state = state.nextState();
	}
}
