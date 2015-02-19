package hodilka.output.swing.graphical;

import hodilka.input.KeyInputSource;
import hodilka.input.swing.SwingKeyInputSource;
import hodilka.input.swing.SwingMouseInputSource;
import hodilka.model.Model;
import hodilka.output.ConsoleInterface;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SwingGraphicsInterface extends JFrame implements ConsoleInterface {

	class ResizeListener implements ComponentListener  {

		@Override
		public void componentResized(ComponentEvent e) {
			
			Rectangle rect = SwingGraphicsInterface.this.getBounds();
			
			SwingGraphicsInterface.this.widthInPixels = rect.width;
			SwingGraphicsInterface.this.heghtInPixels = rect.height;
		}
		@Override
		public void componentMoved(ComponentEvent e) { }
		@Override
		public void componentShown(ComponentEvent e) {}
		@Override
		public void componentHidden(ComponentEvent e) {}
	}
	
	private int widthInPixels;
	private int heghtInPixels;
	
	private Image screen;
	private Graphics screenGraphics;
	private SwingKeyInputSource inputSource;
	
	private ModelRender graphicsRender;
	
	public SwingGraphicsInterface(String title, int widthInPixels, int heghtInPixels) {
		super(title);
		
		this.widthInPixels = widthInPixels;
		this.heghtInPixels = heghtInPixels;
		
		this.setSize(widthInPixels, heghtInPixels);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		inputSource = new SwingKeyInputSource();
		this.addKeyListener(inputSource);
		
		SwingMouseInputSource mouseInputSource = new SwingMouseInputSource();
		
		this.addMouseListener(mouseInputSource);
		this.addMouseMotionListener(mouseInputSource);
		
		try {
			Image image = ImageIO.read(SwingGraphicsInterface.class.getResourceAsStream("/cursor.png"));
			Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(image , new Point(0, 0), "hodilka.cursor");
			this.setCursor (c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		graphicsRender = new GraphicsModelRender();
	}
	
	@Override
	public void init() {
		
		Rectangle rect = this.getBounds();
		
		this.widthInPixels = rect.width;
		this.heghtInPixels = rect.height;
		
		screen = new BufferedImage(widthInPixels, heghtInPixels, BufferedImage.TYPE_INT_RGB);
		screenGraphics = screen.getGraphics();
		
		this.setSize(widthInPixels, heghtInPixels);
				
		setVisible(true);
//		setResizable(false);
		
		this.addComponentListener(this.new ResizeListener());
	}

	@Override
	public synchronized void clear() {
		// FIXME why? slows down rendering!
//		screenGraphics.clearRect(0, 0, widthInPixels, heghtInPixels);
	}

	@Override
	public void flush() {
		this.repaint();
	}

	@Override
	public KeyInputSource getInputSource() {
		return inputSource;
	}

	@Override
	public void draw(Model model) {
		graphicsRender.render(model, screenGraphics, widthInPixels, heghtInPixels);
//		  //Print used memory
//        System.out.println("Used Memory:"
//            + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024*1024));
	}
	
	@Override
	public void paint(Graphics g) {
		
		// TODO repeats to much
//		Image screen = this.screen.getScaledInstance(widthInPixels, widthInPixels, Image.SCALE_FAST);
		
		g.drawImage(screen, 0, 0, null);
	}
	
}
