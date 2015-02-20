package hodilka.output;

import hodilka.output.swing.graphical.SwingGraphicsInterface;

public class OutputInterfaceFactory {
	public static OutputInterface getConsoleInterface(String title, int widthInPixels, int heightInPixels) {
		return new SwingGraphicsInterface(title, widthInPixels, heightInPixels, false);
	}
}
