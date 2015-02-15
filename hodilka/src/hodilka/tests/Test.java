package hodilka.tests;

import hodilka.InputOutputEngie;
import hodilka.model.Model;
import hodilka.model.ModelGenerator;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		
		ModelGenerator modelGenerator = new ModelGenerator();
		
		Model model = modelGenerator.createModel();
		
		InputOutputEngie s = new InputOutputEngie(model);
		s.render();
		
	}

}
