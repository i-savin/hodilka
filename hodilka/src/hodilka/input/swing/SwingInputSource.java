package hodilka.input.swing;

import hodilka.input.InputSource;
import hodilka.input.PlayerInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SwingInputSource implements InputSource, KeyListener, MouseListener, MouseMotionListener {

	private PlayerInput pki = new PlayerInput();

	@Override
	public synchronized PlayerInput getInput() {
		return pki;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		pki.setKeyCode(e.getKeyCode());
		pki.setModifiers(e.getModifiers());
		pki.setKeyPressed(true);
//		System.out.println("Key " + e.getKeyChar());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pki.setMouseX(e.getPoint().x);
		pki.setMouseY(e.getPoint().y);
		pki.setMouseMoved(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		pki.setButton(e.getButton());
		pki.setMouseButtonChanged(true);
	}

	public void keyTyped(KeyEvent e)		{ /* no implementation */ }
	public void keyReleased(KeyEvent e)		{ /* no implementation */ }
	public void mouseDragged(MouseEvent e)	{ /* no implementation */ }
	public void mousePressed(MouseEvent e)	{ /* no implementation */ }
	public void mouseReleased(MouseEvent e)	{ /* no implementation */ }
	public void mouseEntered(MouseEvent e)	{ /* no implementation */ }
	public void mouseExited(MouseEvent e)	{ /* no implementation */ }

}
