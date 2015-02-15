package hodilka;

import hodilka.input.InputSystem;
import hodilka.model.Model;
import hodilka.output.ConsoleInterface;
import hodilka.output.ConsoleInterfaceFactory;
import hodilka.output.OutputSystem;

public class InputOutputEngie {
	
	private final int widthInChars;
	private final int heightInChars;

	private InputSystem inputSystem;
	private OutputSystem outputSystem;

	public InputOutputEngie (Model model) {
		this.widthInChars = model.getWidthInChars();
		this.heightInChars = model.getHeightInChars();
		
		// output system initialization
		ConsoleInterface consoleInterface = ConsoleInterfaceFactory.getConsoleInterface("Hodilka", widthInChars, heightInChars);
		consoleInterface.init();
		outputSystem = new OutputSystem(consoleInterface, model);
		
		// input system initialization
		inputSystem = new InputSystem(consoleInterface.getInputSource());
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
	
	public OutputSystem getOutputSystem() {
		return outputSystem;
	}
}
