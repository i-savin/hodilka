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
			
			if (playerInput.getKeyCode() == 65) { // a
				model.getPlayer().moveLeft();
			}
			if (playerInput.getKeyCode() == 87) { // w
				model.getPlayer().moveUp();
			}
			if (playerInput.getKeyCode() == 68) { // d
				model.getPlayer().moveRight();
			}
			if (playerInput.getKeyCode() == 88) { // x
				model.getPlayer().moveDown();
			}
			
			if (playerInput.getKeyCode() == 81) { // q
				model.getPlayer().moveLeftUp();
			}
			if (playerInput.getKeyCode() == 69) { // e
				model.getPlayer().moveRightUp();
			}
			if (playerInput.getKeyCode() == 90) { // z
				model.getPlayer().moveLeftDown();
			}
			if (playerInput.getKeyCode() == 67) { // c
				model.getPlayer().moveRightDown();
			}
			
			
			if (playerInput.getKeyCode() == 73) { // i
				model.getInventory().setOpend(!model.getInventory().isOpend());
			}
			
		}
		
		if (playerInput.isMouseMoved()) {
//			model.checkSelection(playerInput.getMouseX(), playerInput.getMouseY(),
//					playerInput.getActualWidthInPixels(), playerInput.getActualHeightInPixels());
		}
		
		model.checkSelection(playerInput.getMouseX(), playerInput.getMouseY(),
				playerInput.getActualWidthInPixels(), playerInput.getActualHeightInPixels());
		
		if (playerInput.isMouseButtonChanged()) {
//			System.out.println("Mouse ! " + playerInput.getButton());
		}
		
	}

	@Override
	public boolean isFinalState() {
		return false;
	}

}
