package hodilka;

import hodilka.input.InputSystem;
import hodilka.model.Model;
import hodilka.output.OutputInterface;
import hodilka.output.OutputInterfaceFactory;
import hodilka.output.OutputSystem;

public class InputOutputEngie {
	
	private InputSystem inputSystem;
	private OutputSystem outputSystem;

	public InputOutputEngie (Model model) {

		// output system initialization
		OutputInterface consoleInterface = OutputInterfaceFactory.getConsoleInterface("Hodilka", 640, 480);
		consoleInterface.init(model);
		outputSystem = new OutputSystem(consoleInterface);
		
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
