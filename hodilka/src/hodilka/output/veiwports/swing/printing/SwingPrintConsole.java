package hodilka.output.veiwports.swing.printing;

import hodilka.exceptions.ValidationException;
import hodilka.input.InputSource;
import hodilka.input.swing.SwingInputSource;
import hodilka.model.GameObjectRepresentation;
import hodilka.output.ConsoleInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

@SuppressWarnings("serial")
public class SwingPrintConsole extends JFrame implements ConsoleInterface {
	
	public static final int CHARS_WIDTH = 80;
	public static final int CHARS_HEIGHT = 80;
	
	public static final Color DEFAULT_CAHR_COLOR = Color.WHITE;
	
	private int widthInPixels;
	private int heightInPixels;
	
	private char[][] charBuffer = new char[CHARS_WIDTH][CHARS_HEIGHT];
	private Color[][] colorBuffer = new Color[CHARS_WIDTH][CHARS_HEIGHT];
	
	private JTextPane textPane = new JTextPane();
	private Font font = new Font("Courier New", Font.PLAIN, 10);
	private boolean fontInitialized;
	
	private SwingInputSource inputSource;
	
	public SwingPrintConsole(String title, int widthInPixels, int heightInPixels) {
		this(title, widthInPixels, heightInPixels, false);
	}
	
	public SwingPrintConsole(String title) {
		this(title, -1, -1, true);
	}
	
	public SwingPrintConsole(String title, int widthInPixels, int heightInPixels, boolean fullscreen) {
		super(title);
		
		if (fullscreen) {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			
			this.widthInPixels = (int) dimension.getWidth();
			this.heightInPixels = (int) dimension.getHeight();
			
			this.setSize(this.widthInPixels, this.heightInPixels);
			textPane.setSize(this.widthInPixels, this.heightInPixels);
			
			this.setUndecorated(true);
		} else {
			this.widthInPixels = widthInPixels;
			this.heightInPixels = heightInPixels;
			
			this.setSize(this.widthInPixels, this.heightInPixels);
			textPane.setSize(this.widthInPixels, this.heightInPixels);
			
			// Чтобы окно появлялось в центре экрана
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - this.widthInPixels)/2);
		    int y = (int) ((dimension.getHeight() - this.heightInPixels)/2);
		    this.setLocation(x, y);
		}
	    
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textPane.setForeground(DEFAULT_CAHR_COLOR);
		textPane.setBackground(Color.BLACK);
		textPane.setEditable(false);
		this.add(textPane);
		this.setResizable(false);
		
		inputSource = new SwingInputSource();
		textPane.addKeyListener((KeyListener) inputSource);
		this.addKeyListener((KeyListener) inputSource);
		
		
		// закрыть окно на [ESC]
		textPane.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close-window");
		final JFrame mainWindow = this;
		Action dispatchClosing = new AbstractAction() { 
	        public void actionPerformed(ActionEvent event) { 
	        	mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
	        }
	    }; 
	    textPane.getActionMap().put("close-window", dispatchClosing);
//	    textPane.setContentType("text/plain"); // FIXME: зачем?
	}
	
	@Override
	public void init() { }
	
	public void paint(Graphics g) {		
		if (!fontInitialized) {
			
			FontMetrics fontMetrics = textPane.getGraphics().getFontMetrics();
			
			double charWidth = ((double)widthInPixels) / (double)CHARS_WIDTH;
			double charHeight = ((double)heightInPixels) / (double)CHARS_HEIGHT;
			
//			double charWidth = ((double)textPane.getWidth()) / (double)CHARS_WIDTH;
//			double charHeight = ((double)textPane.getHeight()) / (double)CHARS_HEIGHT;
			
			// Create a new transformation, translating the x, y position
			// This appears to be trying to place the text at the bottom
			// left position of the region, but the problem is, this then gets
			// scaled, when means that this translation is no longer the same...   
			AffineTransform transformation = AffineTransform.getTranslateInstance(0, 0);
	
			// Apply a scale...
		    transformation.scale(charWidth/fontMetrics.getWidths()[0], charHeight/fontMetrics.getHeight());
			
		    // Create a new instance of the font using the transformation
		    font = font.deriveFont(transformation);
		    
		    fontMetrics = textPane.getGraphics().getFontMetrics();
		    
		    textPane.setFont(font);
			
		    // Make it look pretty
		    ((Graphics2D)textPane.getGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			fontInitialized = true;
		}	
	}
	
	public void print(int i, int j, char what, Color color) {
		if (areValidIndexes(i, j)) {
			charBuffer[i][j] = what;
			colorBuffer[i][j] = color;
		}
	}
	
	public void print(int i, int j, char what) {
		print(i, j, what, DEFAULT_CAHR_COLOR);
	}
	
	@Override
	public void draw(GameObjectRepresentation[][] modelRep) {
		for (int i = 0; i < modelRep.length; i++) {
	    	for (int j = 0; j < modelRep[i].length; j++) {
	    		GameObjectRepresentation gor = modelRep[i][j];
	    		print(i, j, gor.getSign(), gor.getColor());
	    	}
		}
	}
	
	public void flush() {
		StringBuilder sb = new StringBuilder(CHARS_HEIGHT * CHARS_WIDTH + CHARS_HEIGHT);
		
		for (int i = 0; i < CHARS_HEIGHT; i++) {
	    	for (int j = 0; j < CHARS_WIDTH; j++) {
	    		sb.append(charBuffer[i][j]);
	    	}
	    	sb.append('\n');
	    }
		String data = sb.toString();
		textPane.setText(data);
		SimpleAttributeSet red = new SimpleAttributeSet();
		try {
			textPane.getDocument().insertString(0, data, red);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textPane.repaint();
		System.out.println(data);
	}
	
	public char peekChar(int i, int j) throws ValidationException {
		if (areValidIndexes(i, j)) {
			return charBuffer[i][j];
		} else {
			throw new ValidationException("Wrong (i, j) == (" + i + "," + j + ")");
		}
    }

    public Color peekColor(int i, int j) throws ValidationException {
    	if (areValidIndexes(i, j)) {
			return colorBuffer[i][j];
		} else {
			throw new ValidationException("Wrong (i, j) == (" + i + "," + j + ")");
		}
    }
	
    @Override
	public void clear() {
		textPane.setText("");
		
	    for (int i = 0; i < CHARS_HEIGHT; i++) {
	    	for (int j = 0; j < CHARS_WIDTH; j++) {
	    		charBuffer[i][j] = ' ';
	    		colorBuffer[i][j] = DEFAULT_CAHR_COLOR;
	    	}
	    }
	}
	
	private boolean areValidIndexes(int i, int j) {
		return 0 <= i && i < CHARS_HEIGHT && 0 <= j && j < CHARS_WIDTH;
	}

	@Override
	public int getWidhtInChars() {
		return CHARS_WIDTH;
	}

	@Override
	public int getHeightInChars() {
		return CHARS_HEIGHT;
	}


	@Override
	public InputSource getInputSource() {
		return inputSource;
	}
	
	
    public static void main(String[] args) {
//		SwingConsoleInterface c = new SwingConsoleInterface("MainWindow");
//		SwingConsoleInterface c = new SwingConsoleInterface("MainWindow", 640*2, 480*2);
		SwingPrintConsole c = new SwingPrintConsole("MainWindow", 480*2, 480*2);
//		SwingConsoleInterface c = new SwingConsoleInterface("MainWindow", 640, 480);
//		SwingConsoleInterface c = new SwingConsoleInterface("MainWindow", 1680, 1050);
		c.setVisible(true);
		c.clear();
		c.print(50, 50, '@');
		for (int i = 0; i < CHARS_HEIGHT; i++) {
			for (int j = 0; j < CHARS_WIDTH; j++)
				if ( i == 0 || j == 0 || i == CHARS_HEIGHT -1 || j == CHARS_WIDTH - 1)
					c.print(i,j, '*');
				else
					c.print(i, j, (char)('0' + i % 10));
		}
//		textPane.setText("123456789\nABCDabcd---++");
		c.flush();
	}

}
