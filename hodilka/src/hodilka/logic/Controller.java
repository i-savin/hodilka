package hodilka.logic;

import hodilka.InputOutputEngie;

public class Controller {
	private ControllerState state = new ControllerStateInitial();
	private GameContext gameContext = new GameContext();
	
	public Controller(InputOutputEngie screen) {
		gameContext.setScreen(screen);
	}

	public boolean isDone() {
		return state.isFinalState();
	}

	public void nextState() {
		state.perform(gameContext);
		state = state.nextState();
	}
}
