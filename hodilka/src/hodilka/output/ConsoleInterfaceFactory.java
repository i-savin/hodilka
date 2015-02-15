package hodilka.output;

import hodilka.output.veiwports.swing.drawing.SwingDrawingConsole;


public class ConsoleInterfaceFactory {
	public static ConsoleInterface getConsoleInterface(String title, int widthInPixels, int heightInPixels) {
		return new SwingDrawingConsole(title, widthInPixels, heightInPixels);
	}
}
