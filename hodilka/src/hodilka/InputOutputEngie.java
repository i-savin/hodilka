package hodilka;

import hodilka.input.InputSystem;
import hodilka.model.Model;
import hodilka.output.ConsoleInterface;
import hodilka.output.ConsoleInterfaceFactory;
import hodilka.output.OutputSystem;

public class InputOutputEngie {
	
	private InputSystem inputSystem;
	private OutputSystem outputSystem;

	public InputOutputEngie (Model model) {

		// output system initialization
		ConsoleInterface consoleInterface = ConsoleInterfaceFactory.getConsoleInterface("Hodilka", 640, 480);
		consoleInterface.init();
		outputSystem = new OutputSystem(consoleInterface, model);
		
		// input system initialization
		inputSystem = new InputSystem(consoleInterface.getInputSource());
	}
	
	public InputSystem getInputSystem() {
		return inputSystem;
	}
	
	public OutputSystem getOutputSystem() {
		return outputSystem;
	}
}
