package hodilka.logic;

public interface ControllerState {
	
	ControllerState nextState();

	void perform(GameContext gameContext);

	boolean isFinalState();
}
