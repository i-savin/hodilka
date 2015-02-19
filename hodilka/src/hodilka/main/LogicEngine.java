package hodilka.main;

import hodilka.input.PlayerKeyInput;
import hodilka.model.Model;

public class LogicEngine {

	private Model model;
	
	public LogicEngine(Model model) {
		this.model = model;
	}

	public void processInput(PlayerKeyInput playerInput) {
		if (!playerInput.isEmpty()) {
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
	}

	public boolean isDone() {
		return false;
	}

}
