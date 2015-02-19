package hodilka.output.swing.graphical;

import hodilka.model.Model;

import java.awt.Graphics;

public class GraphicsModelRender implements ModelRender {

	@Override
	public void render(Model model, Graphics graphicContext, int widthInPixels, int heghtInPixels) {
		renderField(model, graphicContext);
		renderPlayer(model, graphicContext);
		
	}

	private void renderField(Model model, Graphics graphicContext) {
		
		int playerX = model.getPlayer().getTransform().getHorizontalCord();
		int playerY = model.getPlayer().getTransform().getVerticalCord();

		int cellWidth = model.getField().getCell(0, 0).getRepresentation().getImage().getWidth(null);
		int cellHeight = model.getField().getCell(0, 0).getRepresentation().getImage().getHeight(null);
		
		for (int i = 0; i < model.getField().getHeightInCells(); i++) {
			for (int j = 0; j < model.getField().getWigthInCells(); j++) {
				graphicContext.drawImage(model.getField().getCell(i, j).getRepresentation().getImage(), j * cellWidth, i * cellHeight, null);
			}
		}
	}

	private void renderPlayer(Model model, Graphics graphicContext) {
		int playerX = model.getPlayer().getTransform().getHorizontalCord();
		int playerY = model.getPlayer().getTransform().getVerticalCord();

		graphicContext.drawImage(model.getPlayer().getRepresentation().getImage(), playerX, playerY, null);
	}

}
