package hodilka.main;

import hodilka.input.PlayerInput;
import hodilka.model.Model;

public class LogicEngine {

	private Model model;
	
	public LogicEngine(Model model) {
		this.model = model;
	}

	public void processInput(PlayerInput playerInput) {
		
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
			int j = playerInput.getMouseX() / 40;
			int i = playerInput.getMouseY() / 40;
			model.getField().selectCell(i, j);
		}
		
		if (playerInput.isMouseButtonChanged()) {
//			System.out.println("Mouse ! " + playerInput.getButton());
		}
		
		playerInput.clear();
	}

	public boolean isDone() {
		return false;
	}

}
