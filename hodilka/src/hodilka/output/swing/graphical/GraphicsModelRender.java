package hodilka.output.swing.graphical;

import hodilka.model.GameField;
import hodilka.model.Model;

import java.awt.Graphics;

public class GraphicsModelRender implements ModelRender {

	private int screenWidthInPixels;
	private int screenHeghtInPixels;
	
	private Model model;
	
	private Graphics screenGraphicContext;
	
	public GraphicsModelRender(Model model) {
		this.model = model;
	}
	
	@Override
	public void render(Graphics screenGraphicContext, int screenWidthInPixels, int screenHeghtInPixels) {
		
		this.screenGraphicContext = screenGraphicContext;
		
		this.screenWidthInPixels = screenWidthInPixels;
		this.screenHeghtInPixels = screenHeghtInPixels;
		
		renderField(model);
		renderHud(model);
		
		if (model.getInventory().isOpend()) {
			renderInventory(model);
		}
		
		renderContextMenu(model);
		
	}

	private void renderField(Model model) {
		
		int cellWidth = model.getField().getCell(0, 0).getRepresentation().getImage().getWidth(null);
		int cellHeight = model.getField().getCell(0, 0).getRepresentation().getImage().getHeight(null);
		
		// field centred camera: begin
//		int widthScaleFactor = (screenWidthInPixels - model.getField().getWidthInPixels()) / 2;
//		int heightScaleFactor = (screenHeghtInPixels - model.getField().getHeightInPixels()) / 2;
//		
//		screenGraphicContext.drawImage(fieldImage, widthScaleFactor, heightScaleFactor, null);
		// field centred camera: end
		
		// player centred camera: begin
		int playerX = model.getPlayer().getGameObject().getLocationCell().getJ() * cellWidth + cellWidth / 2;
		int playerY = model.getPlayer().getGameObject().getLocationCell().getI() * cellHeight + cellHeight / 2;

		int screenCenterX = screenWidthInPixels / 2;
		int screenCenterY = screenHeghtInPixels / 2;
		
		int widthScaleFactor = screenCenterX - playerX;
		int heightScaleFactor = screenCenterY - playerY;
		// player centred camera: end
		
		GameField field = model.getField(); 
		
		for (int i = 0; i < model.getField().getHeightInCells(); i++) {
			for (int j = 0; j < model.getField().getWigthInCells(); j++) {
				field.getCell(i, j).render(screenGraphicContext, widthScaleFactor + j * cellWidth, heightScaleFactor + i * cellHeight);
				
			}
		}

	}

	private void renderHud(Model model) {	
		
		int hudX = (this.screenWidthInPixels - model.getHud().getWidthInPixels()) / 2; // center on horizontal
		int hudY = this.screenHeghtInPixels - model.getHud().getHeightInPixels();      // down on vertical
		screenGraphicContext.drawImage(model.getHud().getImg(), hudX, hudY, null);
	}

	private void renderInventory(Model model) {
		
		int widthScaleFactor = (screenWidthInPixels - model.getInventory().getWidthInPixels()) / 2;
		int heightScaleFactor = (screenHeghtInPixels - model.getInventory().getHeightInPixels()) / 2;
		
		screenGraphicContext.drawImage(model.getInventory().getImg(), widthScaleFactor, heightScaleFactor, null);
		
	}

	private void renderContextMenu(Model model) {
		// TODO Auto-generated method stub
		
	}
}
