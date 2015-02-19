package hodilka.output;

import hodilka.output.swing.graphical.SwingGraphicsInterface;

public class ConsoleInterfaceFactory {
	public static ConsoleInterface getConsoleInterface(String title, int widthInPixels, int heightInPixels) {
//		return new SwingDrawingConsole(title, widthInPixels, heightInPixels);
		return new SwingGraphicsInterface(title, widthInPixels, heightInPixels);
	}
}
