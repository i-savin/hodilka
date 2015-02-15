package hodilka;

import hodilka.input.InputSystem;
import hodilka.model.Model;
import hodilka.output.ConsoleInterface;
import hodilka.output.ConsoleInterfaceFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InputOutputEngie {
	
	private static final Comparator<Window> layerSortComparatorLessToGreater = new Comparator<Window>() {
		@Override
		public int compare(Window w1, Window w2) {
			return w1.getLayer() - w2.getLayer();
		}
	}; 
	
	private final int widthInChars;
	private final int heightInChars;
	private ConsoleInterface consoleInterface;
	private List<Window> windows = new LinkedList<Window>();

	private InputSystem inputSystem;
	private final Model model;

	public InputOutputEngie (Model model) {
		this.model = model;
		this.widthInChars = model.getWidthInChars();
		this.heightInChars = model.getHeightInChars();
		consoleInterface = ConsoleInterfaceFactory.getConsoleInterface("Hodilka", widthInChars, heightInChars);
		consoleInterface.init();
		inputSystem = new InputSystem(consoleInterface.getInputSource());
		clear();
	}

	public void clear() {
		consoleInterface.clear();
	}
	
	public Window createWindow(int i, int j, int width, int height, String name) {
		Window window = new Window(i, j, width, height, name);
		
		int layer = 0;
		for (Window w: windows) {
			if (w.getLayer() > layer) {
				layer = w.getLayer();
			}
		}
		window.setLayer(layer + 1);
		
		windows.add(window);
		
		return window;
	}
	
	public void deleteWindow(Window window) {
		windows.remove(window);
	}
	
	public void render() {
		clear();
		
//		Collections.sort(windows, layerSortComparatorLessToGreater);
//		int tmpI, tmpJ;
//		
//		for (Window window: windows) {
//			for (int i = 0; i < window.getHeight(); i++) {
//				for (int j = 0; j < window.getWidth(); j++) {
//					tmpI = i + window.getLeftUpperI();
//					tmpJ = j + window.getLeftUpperJ();
//						consoleInterface.print(tmpI, tmpJ, window.getCharAt(i, j));
//				}
//			}
//		}
		
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
