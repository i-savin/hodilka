package hodilka.output.swing.graphical;

import hodilka.model.GameField;
import hodilka.model.Model;

import java.awt.Graphics;

public class GraphicsModelRender implements ModelRender {

	private int screenWidthInPixels;
	private int screenHeightInPixels;
	
	private Model model;
	
	private Graphics screenGraphicContext;
	
	public GraphicsModelRender(Model model) {
		this.model = model;
	}
	
	@Override
	public void render(Graphics screenGraphicContext, int screenWidthInPixels, int screenHeghtInPixels) {
		
		this.screenGraphicContext = screenGraphicContext;
		
		this.screenWidthInPixels = screenWidthInPixels;
		this.screenHeightInPixels = screenHeghtInPixels;
		
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
		
		// player centered camera: begin
		int playerX = model.getPlayer().getGameObject().getLocationCell().getJ() * cellWidth + cellWidth / 2;
		int playerY = model.getPlayer().getGameObject().getLocationCell().getI() * cellHeight + cellHeight / 2;

		int screenCenterX = screenWidthInPixels / 2;
		int screenCenterY = screenHeightInPixels / 2;
		
		int widthScaleFactor = screenCenterX - playerX;
		int heightScaleFactor = screenCenterY - playerY;
		// player centered camera: end
		
		GameField field = model.getField(); 
		
		// calculate coordinates bounds of visible tiles
		int fromJ = 0;
		if (widthScaleFactor < 0)
			fromJ = (-widthScaleFactor) / cellWidth;
		
		if (fromJ > 0 )
			fromJ--;
		
		int toJ = model.getField().getWigthInCells();
		if (model.getField().getWidthInPixels() + widthScaleFactor > screenWidthInPixels) 
			toJ = (screenWidthInPixels - widthScaleFactor) / cellWidth;
		if (toJ < model.getField().getWigthInCells())
			toJ++;
		
		
		int fromI = 0;
		if (heightScaleFactor < 0)
			fromI = (-heightScaleFactor) / cellHeight;
		
		if (fromI > 0 )
			fromI--;
		
		int toI = model.getField().getHeightInCells();
		if (model.getField().getHeightInPixels() + heightScaleFactor > screenHeightInPixels) 
			toI = (screenHeightInPixels - heightScaleFactor) / cellHeight;
		if (toI < model.getField().getHeightInCells())
			toI++;
		
//		for (int i = 0; i < model.getField().getHeightInCells(); i++) {
//		for (int j = 0; j < model.getField().getWigthInCells(); j++) {
		
		// walk throw visible tiles only
		for (int i = fromI; i < toI; i++) {
			for (int j = fromJ; j < toJ; j++) {
				field.getCell(i, j).render(screenGraphicContext, widthScaleFactor + j * cellWidth, heightScaleFactor + i * cellHeight);
			}
		}
	}

	private void renderHud(Model model) {	
		
		int hudX = (this.screenWidthInPixels - model.getHud().getWidthInPixels()) / 2; // center on horizontal
		int hudY = this.screenHeightInPixels - model.getHud().getHeightInPixels();      // down on vertical
		screenGraphicContext.drawImage(model.getHud().getImg(), hudX, hudY, null);
	}

	private void renderInventory(Model model) {
		
		int widthScaleFactor = (screenWidthInPixels - model.getInventory().getWidthInPixels()) / 2;
		int heightScaleFactor = (screenHeightInPixels - model.getInventory().getHeightInPixels()) / 2;
		
		screenGraphicContext.drawImage(model.getInventory().getImg(), widthScaleFactor, heightScaleFactor, null);
		
	}

	private void renderContextMenu(Model model) {
		// TODO Auto-generated method stub
		
	}
}
