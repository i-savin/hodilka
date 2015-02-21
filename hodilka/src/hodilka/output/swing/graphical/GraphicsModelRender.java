package hodilka.output.swing.graphical;

import hodilka.model.GameField;
import hodilka.model.Model;

import java.awt.Graphics;

public class GraphicsModelRender implements ModelRender {

	private int widthInPixels;
	private int heghtInPixels;
	@Override
	public void render(Model model, Graphics graphicContext, int widthInPixels, int heghtInPixels) {
		
		this.widthInPixels = widthInPixels;
		this.heghtInPixels = heghtInPixels;
		
		renderField(model, graphicContext);
		renderPlayer(model, graphicContext);
		renderHud(model, graphicContext);
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

	private void renderPlayer(Model model, Graphics graphicContext) {
		int playerX = model.getPlayer().getTransform().getHorizontalCord();
		int playerY = model.getPlayer().getTransform().getVerticalCord();

		graphicContext.drawImage(model.getPlayer().getRepresentation().getImage(), playerX, playerY, null);
	}

	private void renderHud(Model model, Graphics graphicContext) {
		graphicContext.drawString("10/10", 50, heghtInPixels - 50);
	}
}
