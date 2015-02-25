package hodilka.input.swing;

import hodilka.input.InputSource;
import hodilka.input.PlayerInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SwingInputSource implements InputSource, KeyListener, MouseListener, MouseMotionListener {

	private final PlayerInput playerInput = new PlayerInput();

	@Override
	public PlayerInput getInput() {
		return playerInput;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		playerInput.setKeyCode(e.getKeyCode());
		playerInput.setModifiers(e.getModifiers());
		playerInput.setKeyPressed(true);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		playerInput.setMouseX(e.getPoint().x);
		playerInput.setMouseY(e.getPoint().y);
		playerInput.setMouseMoved(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		playerInput.setButton(e.getButton());
		playerInput.setMouseButtonChanged(true);
	}
	
	public void setWidthAndHeight(int width, int height) {
		playerInput.setActualWidthInPixels(width);
		playerInput.setActualHeightInPixels(height);
	}
	
	public void keyTyped(KeyEvent e)		{ /* no implementation */ }
	public void keyReleased(KeyEvent e)		{ /* no implementation */ }
	public void mouseDragged(MouseEvent e)	{ /* no implementation */ }
	public void mousePressed(MouseEvent e)	{ /* no implementation */ }
	public void mouseReleased(MouseEvent e)	{ /* no implementation */ }
	public void mouseEntered(MouseEvent e)	{ /* no implementation */ }
	public void mouseExited(MouseEvent e)	{ /* no implementation */ }

}
