package hodilka.logic;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public interface ControllerState {
	
	ControllerState nextState();

	void perform(Model model, PlayerInput playerInput);

	boolean isFinalState();
}
