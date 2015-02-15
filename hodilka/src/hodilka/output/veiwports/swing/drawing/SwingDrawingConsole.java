package hodilka.output.veiwports.swing.drawing;

import hodilka.input.InputSource;
import hodilka.input.swing.SwingInputSource;
import hodilka.model.GameObjectRepresentation;
import hodilka.output.ConsoleInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SwingDrawingConsole extends JFrame implements ConsoleInterface {

	
	public static final int WIDTH_IN_CHARS = 100;
	public static final int HEIGHT_IN_CHARS = 80;
	
	private TextPanel textPanel;
	private int widthInPixels;
	private int heightInPixels;
	
	private Color defaultBackgroundColor = Color.BLACK;
	private Color defaultForegroundColor = Color.WHITE;
	
	// FIXME: hardcoded
	private boolean fullscreen = true;
	private InputSource inputSource;
	
	public SwingDrawingConsole(String title, int width, int height) {
		super(title);
		
		if (fullscreen) { // fullscreen
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			
			this.widthInPixels = (int) dimension.getWidth();
			this.heightInPixels = (int) dimension.getHeight();
			
			this.setUndecorated(true);
		} else {
			widthInPixels = width;
			heightInPixels = height;
		}
		this.setSize(widthInPixels, heightInPixels);
		textPanel = new TextPanel(widthInPixels, heightInPixels);
		getContentPane().setLayout(new BorderLayout(1, 1));
		getContentPane().add(textPanel);
		
		pack();
		
		setBackground(defaultBackgroundColor);
		
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		textPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close-window");
		final JFrame mainWindow = this;
		Action dispatchClosing = new AbstractAction() { 
	        public void actionPerformed(ActionEvent event) { 
	        	mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
	        }
	    }; 
	    textPanel.getActionMap().put("close-window", dispatchClosing);
	    
	    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor"));
	}
	
	@Override
	public void init() {
		textPanel.init();
		this.setSize(widthInPixels, heightInPixels);
		textPanel.setSize(getBounds().width, getBounds().height);
		repaint();
		setVisible(true);
		
		inputSource = new SwingInputSource();
		textPanel.addKeyListener((KeyListener) inputSource);
		this.addKeyListener((KeyListener) inputSource);
	}
	
	@Override
	public void draw(GameObjectRepresentation[][] modelRep) {
		for (int i = 0; i < modelRep.length; i++) {
	    	for (int j = 0; j < modelRep[i].length; j++) {
	    		GameObjectRepresentation gor = modelRep[i][j];
	    		textPanel.print(i, j, gor.getSign(), gor.getColor(), defaultBackgroundColor);
	    	}
		}
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < HEIGHT_IN_CHARS; i++) {
	    	for (int j = 0; j < WIDTH_IN_CHARS; j++) {
	    		textPanel.print(i, j, ' ', defaultForegroundColor, defaultBackgroundColor);
	    	}
	    }
	}

	@Override
	public void flush() {
		textPanel.repaint();
	}
	
	@Override
	public int getWidhtInChars() {
		return textPanel.getWidhtInChars();
	}

	@Override
	public int getHeightInChars() {
		return textPanel.getHeightInChars();
	}
	
	@Override
	public InputSource getInputSource() {
		return inputSource;
	}
	
	public static void main(String[] args) {
		
		Color colors[] = {Color.BLUE, Color.WHITE, Color.RED, Color.GREEN};
		
		SwingDrawingConsole console = new SwingDrawingConsole("Title", 640, 480);
		console.init();
		console.clear();
		
		for (int i = 0; i < HEIGHT_IN_CHARS; i++) {
			console.textPanel.print(i, 0, (char)('0' + i % 10), colors[i % colors.length], colors[(i+1) % colors.length]);
		}
		
		for (int i = 0; i < WIDTH_IN_CHARS; i++) {
			console.textPanel.print(0, i, (char)('0' + i % 10), colors[i % colors.length], colors[(i+1) % colors.length]);
		}
		
		console.repaint();
	}

}
