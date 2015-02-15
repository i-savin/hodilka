package hodilka.logic;

import hodilka.InputOutputEngie;

public class ControllerStateInitial implements ControllerState {

	@Override
	public ControllerState nextState() {
		return new ControllerStateStartMenu();
	}

	@Override
	public boolean isFinalState() {
		return false;
	}

	@Override
	public void perform(GameContext gameContext) {
		InputOutputEngie screen = gameContext.getScreen();
	}

}
