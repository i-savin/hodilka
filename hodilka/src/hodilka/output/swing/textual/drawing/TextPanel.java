package hodilka.output.swing.textual.drawing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TextPanel extends JPanel {
	
	
	public static final int WIDTH_IN_CHARS = 100;
	public static final int HEIGHT_IN_CHARS = 80;
	
	private Font font;
	
	private int fontWidth;
	private int fontDown;
	private int ascent;
	
	private char[][] charBuffer = new char[HEIGHT_IN_CHARS][WIDTH_IN_CHARS];
	private Color[][] foregroundClolorBuffer = new Color[HEIGHT_IN_CHARS][WIDTH_IN_CHARS];
	private Color[][] backgroundClolorBuffer = new Color[HEIGHT_IN_CHARS][WIDTH_IN_CHARS];
	private boolean[][] needToRedraw = new boolean[HEIGHT_IN_CHARS][WIDTH_IN_CHARS];
			
	private Image textImageBuffer;
	private Graphics textImageGraphics;
	private int widthInPixels;
	private int heightInPixels;

	public TextPanel(int width, int height) {
		super(true); // double buffered
		widthInPixels = width;
		heightInPixels = height;
		
		setBounds(0, 0, widthInPixels, heightInPixels);
	}

	public void init() {
		textImageBuffer = createImage(widthInPixels, heightInPixels);
		textImageGraphics = textImageBuffer.getGraphics();
		initFont(widthInPixels, heightInPixels);
	}
	
	private void initFont(int width, int height) {
		// Create font
		Font curierFont = new Font("Courier New", Font.PLAIN, 8);
		textImageGraphics.setFont(curierFont);
		
		FontMetrics fontMetrics = textImageGraphics.getFontMetrics();
		
		double charWidth = ((double)(width)) / (double)WIDTH_IN_CHARS;
		double charHeight = ((double)height) / (double)HEIGHT_IN_CHARS;
				
		// Create a new transformation, translating the x, y position
		// This appears to be trying to place the text at the bottom
		// left position of the region, but the problem is, this then gets
		// scaled, when means that this translation is no longer the same...   
		AffineTransform transformation = AffineTransform.getTranslateInstance(0, 0);

		// Apply a scale...
	    transformation.scale(charWidth/fontMetrics.getWidths()[0], charHeight/fontMetrics.getHeight());
		
	    // Create a new instance of the font using the transformation
	    font = curierFont.deriveFont(transformation);
	    
	    textImageGraphics.setFont(font);
	    
	    fontMetrics = textImageGraphics.getFontMetrics();
	    
		fontWidth = fontMetrics.getWidths()[0];
		fontDown = fontMetrics.getHeight();
		ascent = fontMetrics.getAscent();
	}
	
	public void print(int i, int j, char what, Color foreground, Color background) {
		if (areValidIndexes(i, j)) {
			charBuffer[i][j] = what;
			foregroundClolorBuffer[i][j] = foreground;
			backgroundClolorBuffer[i][j] = background;
			needToRedraw[i][j] = true;
		}
	}

	@Override
	public synchronized void paint(Graphics g) {
		for (int i = 0; i < charBuffer.length; i++) {
			for (int j = 0; j < charBuffer[0].length; j++) {
				if (needToRedraw[i][j]) {
					textImageGraphics.setColor(backgroundClolorBuffer[i][j]);
					textImageGraphics.fillRect(j * fontWidth, i * fontDown, fontWidth, fontDown);
					textImageGraphics.setColor(foregroundClolorBuffer[i][j]);
					textImageGraphics.drawChars(charBuffer[i], j, 1, j * fontWidth, i * fontDown + ascent);
					needToRedraw[i][j] = false;
				}
			}
		}
		g.drawImage(textImageBuffer, 0, 0, null);
	}

	
	private boolean areValidIndexes(int i, int j) {
		return 0 <= i && i < getHeightInChars() && 0 <= j && j < getWidhtInChars();
	}

	public int getWidhtInChars() {
		return WIDTH_IN_CHARS;
	}

	public int getHeightInChars() {
		return HEIGHT_IN_CHARS;
	}
}
