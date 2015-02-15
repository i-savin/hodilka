package hodilka;

import hodilka.input.InputSystem;
import hodilka.model.Model;
import hodilka.output.ConsoleInterface;
import hodilka.output.ConsoleInterfaceFactory;

import java.io.IOException;

public class InputOutputEngie {
	
	private final int widthInChars;
	private final int heightInChars;
	private ConsoleInterface consoleInterface;

	private InputSystem inputSystem;
	private final Model model;

	public InputOutputEngie (Model model) {
		this.model = model;
		this.widthInChars = model.getWidthInChars();
		this.heightInChars = model.getHeightInChars();
		consoleInterface = ConsoleInterfaceFactory.getConsoleInterface("Hodilka", widthInChars, heightInChars);
		consoleInterface.init();
		inputSystem = new InputSystem(consoleInterface.getInputSource());
		consoleInterface.clear();
	}

	public void clear() {
		consoleInterface.clear();
	}
	
	public void render() {
		clear();
		
		char[][] modelRep = model.getReprezentation();
		
		for (int i = 0; i < modelRep.length; i++) {
			for (int j = 0; j < modelRep[i].length; j++) {
				consoleInterface.print(i, j, modelRep[i][j]);
			}
		}
		
		consoleInterface.flush();
	}

	public void display() throws IOException {
		consoleInterface.flush();
	}
	
	public int getWidth() {
		return widthInChars;
	}

	public int getHeight() {
		return heightInChars;
	}
	
	public InputSystem getInputSystem() {
		return inputSystem;
	}
}
