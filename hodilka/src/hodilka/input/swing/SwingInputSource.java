package hodilka.input.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import hodilka.input.InputSource;
import hodilka.input.UserInput;

public class SwingInputSource implements InputSource, KeyListener {

	private static final UserInput emptyInput = new UserInput();
	private UserInput ui;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		ui = new UserInput(e.getKeyCode(), e.getModifiers());
		notify();
		//System.out.println(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized UserInput getInput() {
		if (ui != null) {
			UserInput tmp = ui;
			ui = null;
			return tmp;
		} else {
			return emptyInput;
		}
	}

}
