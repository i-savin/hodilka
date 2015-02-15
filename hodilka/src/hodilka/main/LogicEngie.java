package hodilka.main;

import hodilka.input.UserInput;
import hodilka.model.Model;

public class LogicEngie {

	private Model model;
	
	public LogicEngie(Model model) {
		this.model = model;
	}

	public void processInput(UserInput userInput) {
		if (userInput.getKeyCode() == 37) {
			model.getPlayer().getTransform().moveLeft();
		}
		if (userInput.getKeyCode() == 38) {
			model.getPlayer().getTransform().moveUp();
		}
		if (userInput.getKeyCode() == 39) {
			model.getPlayer().getTransform().moveRight();
		}
		if (userInput.getKeyCode() == 40) {
			model.getPlayer().getTransform().moveDown();
		}
	}

	public boolean isDone() {
		return false;
	}

}
