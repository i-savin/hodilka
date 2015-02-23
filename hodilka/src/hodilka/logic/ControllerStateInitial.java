package hodilka.logic;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public class ControllerStateInitial implements ControllerState {

	@Override
	public ControllerState nextState() {
		return new ControllerStateField();
	}

	@Override
	public boolean isFinalState() {
		return false;
	}

	@Override
	public void perform(Model model, PlayerInput playerInput) {
	}

}
