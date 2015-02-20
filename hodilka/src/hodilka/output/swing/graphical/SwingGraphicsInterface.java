package hodilka.output.swing.graphical;

import hodilka.input.InputSource;
import hodilka.input.swing.SwingInputSource;
import hodilka.model.Model;
import hodilka.output.OutputInterface;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SwingGraphicsInterface extends JFrame implements OutputInterface {

	class ResizeListener implements ComponentListener  {

		@Override
		public void componentResized(ComponentEvent e) {
			
			Rectangle rect = SwingGraphicsInterface.this.getBounds();
			
			SwingGraphicsInterface.this.widthInPixels = rect.width;
			SwingGraphicsInterface.this.heightInPixels = rect.height;
		}
		@Override
		public void componentMoved(ComponentEvent e) { }
		@Override
		public void componentShown(ComponentEvent e) {}
		@Override
		public void componentHidden(ComponentEvent e) {}
	}
	
	private int widthInPixels;
	private int heightInPixels;
	
	private Image screen;
	private Graphics screenGraphics;
	private SwingInputSource inputSource;
	
	private ModelRender graphicsRender;
	
	private boolean fullscreen;
	
	public SwingGraphicsInterface(String title, int widthInPixels, int heightInPixels, boolean fullscreen) {
		super(title);
		
		this.fullscreen = fullscreen;
		
		if (this.fullscreen) {
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			
			this.widthInPixels = (int) dimension.getWidth();
			this.heightInPixels = (int) dimension.getHeight();
			
			this.setUndecorated(true);
		} else {
			this.widthInPixels = widthInPixels;
			this.heightInPixels = heightInPixels;
		}
		
		this.setSize(this.widthInPixels, this.heightInPixels);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		inputSource = new SwingInputSource();
		
		try {
			Image image = ImageIO.read(SwingGraphicsInterface.class.getResourceAsStream("/cursor.png"));
			Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(image , new Point(0, 0), "hodilka.cursor");
			this.setCursor (c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		graphicsRender = new GraphicsModelRender();
		
		// ECS close window hack
		JPanel p = new JPanel();
		p.setSize(0, 0);
		this.add(p);
		
		p.addKeyListener(inputSource);
		p.addMouseListener(inputSource);
		p.addMouseMotionListener(inputSource);

		
		p.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "close-window");
		final JFrame mainWindow = this;
		Action dispatchClosing = new AbstractAction() { 
	        public void actionPerformed(ActionEvent event) { 
	        	mainWindow.dispatchEvent(new WindowEvent(mainWindow, WindowEvent.WINDOW_CLOSING));
	        }
	    }; 
	    p.getActionMap().put("close-window", dispatchClosing);
	}
	
	@Override
	public void init() {
		
		Rectangle rect = this.getBounds();
		
		this.widthInPixels = rect.width;
		this.heightInPixels = rect.height;
		
		screen = new BufferedImage(this.widthInPixels, this.heightInPixels, BufferedImage.TYPE_INT_RGB);
		screenGraphics = screen.getGraphics();
		
		this.setSize(widthInPixels, heightInPixels);
				
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
	public InputSource getInputSource() {
		return inputSource;
	}

	@Override
	public void draw(Model model) {
		graphicsRender.render(model, screenGraphics, widthInPixels, heightInPixels);
//		  //Print used memory
//        System.out.println("Used Memory:"
//            + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024*1024));
	}
	
	@Override
	public void paint(Graphics g) {
		
//		int width = screen.getWidth(null);
//		int height = screen.getHeight(null);
		
		
//		float factorHeight = (float) heightInPixels/height;
//		float factorWidth = (float) widthInPixels/width;
		
//		float readlWidth = Math.min(factorHeight, factorWidth) * width;
//		float readlHeight = Math.min(factorHeight, factorWidth) * height;
		
		// TODO repeats to much
//		Image screen = this.screen.getScaledInstance((int)readlWidth, (int)readlHeight, Image.SCALE_FAST);
		if (fullscreen)
			g.drawImage(screen, 0, 0, null);
		else 
			g.drawImage(screen, 5, 30, null);
	}
	
}
