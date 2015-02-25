package hodilka.output.swing.graphical;

import hodilka.ImageConstants;
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
		
		int cellWidth = ImageConstants.IMAGE_WH;
		int cellHeight = ImageConstants.IMAGE_WH;
		
		// player centered camera: begin
		int playerX = model.getPlayer().getGameObject().getLocationCell().getJ() * cellWidth + cellWidth / 2;
		int playerY = model.getPlayer().getGameObject().getLocationCell().getI() * cellHeight + cellHeight / 2;

		int screenCenterX = screenWidthInPixels / 2;
		int screenCenterY = screenHeightInPixels / 2;
		
		int xFieldOffset = screenCenterX - playerX;
		int yFieldOffset = screenCenterY - playerY;
		// player centered camera: end
		
		// Point (xFieldOffset, yFieldOffset) is offset of upper left field cell relatively to Point(0,0) of application window bound rect 
		
		GameField field = model.getField(); 
		
		// calculate coordinates bounds of visible tiles
		int fromJ = 0;
		if (xFieldOffset < 0)
			fromJ = (-xFieldOffset) / cellWidth;
		if (fromJ > 0 )
			fromJ--;
		
		int toJ = model.getField().getWigthInCells();
		if (model.getField().getWidthInPixels() + xFieldOffset > screenWidthInPixels) 
			toJ = (screenWidthInPixels - xFieldOffset) / cellWidth;
		if (toJ < model.getField().getWigthInCells())
			toJ++;
		
		
		int fromI = 0;
		if (yFieldOffset < 0)
			fromI = (-yFieldOffset) / cellHeight;
		if (fromI > 0 )
			fromI--;
		
		int toI = model.getField().getHeightInCells();
		if (model.getField().getHeightInPixels() + yFieldOffset > screenHeightInPixels) 
			toI = (screenHeightInPixels - yFieldOffset) / cellHeight;
		if (toI < model.getField().getHeightInCells())
			toI++;
		
		// walk throw visible tiles only
		for (int yIndexI = fromI; yIndexI < toI; yIndexI++) {
			for (int xIndexJ = fromJ; xIndexJ < toJ; xIndexJ++) {
				field.getCell(yIndexI, xIndexJ).render(screenGraphicContext, xFieldOffset + xIndexJ * cellWidth, yFieldOffset + yIndexI * cellHeight);
			}
		}
	}

	private void renderHud(Model model) {	
		
		int hudX = (this.screenWidthInPixels - model.getHud().getWidthInPixels()) / 2; // center on horizontal
		int hudY = this.screenHeightInPixels - model.getHud().getHeightInPixels();      // down on vertical
		screenGraphicContext.drawImage(model.getHud().getImg(), hudX, hudY, null);
	}

	private void renderInventory(Model model) {
		
		int xOffset = (screenWidthInPixels - model.getInventory().getWidthInPixels()) / 2;
		int yOffset = (screenHeightInPixels - model.getInventory().getHeightInPixels()) / 2;
		
		screenGraphicContext.drawImage(model.getInventory().getImg(), xOffset, yOffset, null);
		
	}

	private void renderContextMenu(Model model) {
		// TODO Auto-generated method stub
		
	}
}
