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
				model.getPlayer().getTransform().moveLeft();
			}
			if (playerInput.getKeyCode() == 38) {
				model.getPlayer().getTransform().moveUp();
			}
			if (playerInput.getKeyCode() == 39) {
				model.getPlayer().getTransform().moveRight();
			}
			if (playerInput.getKeyCode() == 40) {
				model.getPlayer().getTransform().moveDown();
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
