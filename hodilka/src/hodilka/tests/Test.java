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

		s.createWindow(5, 10, 50, 20, "New Window!");
		
//		Window w = s.createWindow(10, 5, 50, 20, "Another Window!");
		s.createWindow(10, 5, 50, 20, "Another Window!");
		
		s.render();
		
		s.display();
		
//		s.deleteWindow(w);
//		
//		s.redraw();
//		
//		s.display(System.out);
	}

}
