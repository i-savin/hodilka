package hodilka.input.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import hodilka.input.InputSource;
import hodilka.input.PlayerInput;

public class SwingInputSource implements InputSource, KeyListener {

	private static final PlayerInput emptyInput = new PlayerInput();
	private PlayerInput ui;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		ui = new PlayerInput(e.getKeyCode(), e.getModifiers());
		notify();
		//System.out.println(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized PlayerInput getInput() {
		if (ui != null) {
			PlayerInput tmp = ui;
			ui = null;
			return tmp;
		} else {
			return emptyInput;
		}
	}

}
