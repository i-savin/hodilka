package hodilka.input.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import hodilka.input.KeyInputSource;
import hodilka.input.PlayerKeyInput;

public class SwingKeyInputSource implements KeyInputSource, KeyListener {

	private static final PlayerKeyInput emptyInput = new PlayerKeyInput();
	private PlayerKeyInput pki;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pki = new PlayerKeyInput(e.getKeyCode(), e.getModifiers());
		notify();
		System.out.println("Key " + e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// no implementation
	}

	@Override
	public synchronized PlayerKeyInput getInput() {
		if (pki != null) {
			PlayerKeyInput tmp = pki;
			pki = null;
			return tmp;
		} else {
			return emptyInput;
		}
	}

}
