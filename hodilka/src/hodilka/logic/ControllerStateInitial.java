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
		screen.createWindow(0, 0, screen.getWidth(), screen.getHeight(), "Hodilka's Main Menu");
	}

}
