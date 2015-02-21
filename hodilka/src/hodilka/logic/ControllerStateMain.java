package hodilka.logic;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public class ControllerStateMain implements ControllerState {

	@Override
	public ControllerState nextState() {
		return this;
	}

	@Override
	public void perform(Model model, PlayerInput playerInput) {
		
		if (playerInput.isKeyPressed()) {
			if (playerInput.getKeyCode() == 37) {
				model.getPlayer().moveLeft();
			}
			if (playerInput.getKeyCode() == 38) {
				model.getPlayer().moveUp();
			}
			if (playerInput.getKeyCode() == 39) {
				model.getPlayer().moveRight();
			}
			if (playerInput.getKeyCode() == 40) {
				model.getPlayer().moveDown();
			}
		}
		
		if (playerInput.isMouseMoved()) {
			model.checkSelection(playerInput.getMouseX(), playerInput.getMouseY(),
					playerInput.getActualWidthInPixels(), playerInput.getActualHeightInPixels());
		}
		
		if (playerInput.isMouseButtonChanged()) {
//			System.out.println("Mouse ! " + playerInput.getButton());
		}
	}

	@Override
	public boolean isFinalState() {
		return false;
	}

}
