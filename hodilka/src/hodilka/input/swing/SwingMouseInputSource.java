package hodilka.input.swing;

import hodilka.input.MouseInputSource;
import hodilka.input.PlayerMouseInput;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SwingMouseInputSource implements MouseInputSource, MouseListener, MouseMotionListener {

	private PlayerMouseInput pmi;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse " + e.getPoint());
	}

	@Override
	public PlayerMouseInput getInput() {
		// TODO Auto-generated method stub
		return null;
	}
}
