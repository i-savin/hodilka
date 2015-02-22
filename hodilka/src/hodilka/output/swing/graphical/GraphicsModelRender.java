package hodilka.output.swing.graphical;

import hodilka.model.GameField;
import hodilka.model.Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GraphicsModelRender implements ModelRender {

	private int screenWidthInPixels;
	private int screenHeghtInPixels;
	
	private BufferedImage fieldImage;
	private BufferedImage hudImage;
	private BufferedImage inventoryImage;
	private BufferedImage contextMenuImage;
	
	private Model model;
	
	public GraphicsModelRender(Model model) {
		this.model = model;
		this.fieldImage = new BufferedImage(model.getField().getWidthInPixels(), model.getField().getHeightInPixels(), BufferedImage.TYPE_INT_RGB);
		this.hudImage = new BufferedImage(model.getHud().getWidthInPixels(), model.getHud().getHeightInPixels(), BufferedImage.TYPE_INT_RGB);
	}
	
	@Override
	public void render(Graphics screenGraphicContext, int screenWidthInPixels, int screenHeghtInPixels) {
		
		this.screenWidthInPixels = screenWidthInPixels;
		this.screenHeghtInPixels = screenHeghtInPixels;
		
		renderField(model, fieldImage.getGraphics());
		renderHud(model, hudImage.getGraphics());
		renderInventory(model, screenGraphicContext);
		renderContextMenu(model, screenGraphicContext);
		
		int widthScaleFactor = (screenWidthInPixels - model.getField().getWidthInPixels()) / 2;
		int heightScaleFactor = (screenHeghtInPixels - model.getField().getHeightInPixels()) / 2;
		
		screenGraphicContext.drawImage(fieldImage, 0 + widthScaleFactor, 0 + heightScaleFactor, null);
		
		
		int hudX = (this.screenWidthInPixels - model.getHud().getWidthInPixels()) / 2; // center on horizontal
		int hudY = this.screenHeghtInPixels - model.getHud().getHeightInPixels();      // down on vertical
		screenGraphicContext.drawImage(hudImage, hudX, hudY, null);
	}

	private void renderField(Model model, Graphics graphicContext) {
		
		int cellWidth = model.getField().getCell(0, 0).getRepresentation().getImage().getWidth(null);
		int cellHeight = model.getField().getCell(0, 0).getRepresentation().getImage().getHeight(null);
		
		GameField field = model.getField(); 
		
		for (int i = 0; i < model.getField().getHeightInCells(); i++) {
			for (int j = 0; j < model.getField().getWigthInCells(); j++) {
				field.getCell(i, j).render(graphicContext, j * cellWidth, i * cellHeight);
				
			}
		}
	}

	private void renderHud(Model model, Graphics graphicContext) {	
		graphicContext.drawImage(model.getHud().getImg(), 0, 0, null);
	}

	private void renderInventory(Model model, Graphics graphicContext) {
		// TODO Auto-generated method stub
		
	}

	private void renderContextMenu(Model model, Graphics graphicContext) {
		// TODO Auto-generated method stub
		
	}
}
