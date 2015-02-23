package hodilka.logic;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public class ControllerStateInventory implements ControllerState {

	// TODO move to basic class
	private ControllerState next = this;
	
	@Override
	public ControllerState nextState() {
		return next;
	}

	@Override
	public void perform(Model model, PlayerInput playerInput) {
		if (playerInput.isKeyPressed()) {
			
			if (playerInput.getKeyCode() == 73) { // i
				model.getInventory().setOpend(false);
				// TODO need to cache all states
				next = new ControllerStateField();
			}
			
		}
		
		if (playerInput.isMouseMoved()) {
//			model.checkSelection(playerInput.getMouseX(), playerInput.getMouseY(),
//					playerInput.getActualWidthInPixels(), playerInput.getActualHeightInPixels());
		}
		
		if (playerInput.isMouseButtonChanged()) {
//			System.out.println("Mouse ! " + playerInput.getButton());
		}
	}

	@Override
	public boolean isFinalState() {
		// TODO Auto-generated method stub
		return false;
	}

}
