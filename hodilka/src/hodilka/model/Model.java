package hodilka.model;

import hodilka.ImageConstants;

public class Model {
	
	private MainMenu menu;
	
	private Player player;
	private GameField field;
	private GameHud hud;
	private Inventory inventory;
	
	public Model() {
	}

	public GameField getField() {
		return field;
	}

	public void setField(GameField field) {
		this.field = field;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameHud getHud() {
		return hud;
	}

	public void setHud(GameHud hud) {
		this.hud = hud;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void actualizeViewPortSize(int screenWidthInPixels, int screenHeightInPixels) {
		
	}

	public void checkCellSelection(int mouseX, int mouseY, int screenWidthInPixels, int screenHeightInPixels) {
		
		int hudX = (screenWidthInPixels - hud.getWidthInPixels()) / 2; // center on horizontal
		int hudY = screenHeightInPixels - hud.getHeightInPixels();      // down on vertical
		
		// FIXME 5, 30 - window bounds widths
		if (hud.isMouseOver(mouseX - hudX + 5, mouseY - hudY + 30)) {
			field.deselectCell();
		} else {
			// FIXME if one moves this code out of IF and add return in IF then performance will slow down (looks like JVM bug)
			
			// player centered camera
			int playerX = player.getGameObject().getLocationCell().getJ() * ImageConstants.IMAGE_WH + ImageConstants.IMAGE_WH / 2;
			int playerY = player.getGameObject().getLocationCell().getI() * ImageConstants.IMAGE_WH + ImageConstants.IMAGE_WH / 2;
	
			int screenCenterX = screenWidthInPixels / 2;
			int screenCenterY = screenHeightInPixels / 2;
			
			// FIXME 5, 30 - window bounds widths
			int mouseXOffset = playerX - (screenCenterX - mouseX) + 5;
			int mouseYOffset = playerY - (screenCenterY - mouseY) + 30;
			
			if (field.isMouseOver(mouseXOffset, mouseYOffset)) {
				int j = mouseXOffset / ImageConstants.IMAGE_WH;
				int i = mouseYOffset / ImageConstants.IMAGE_WH;
				field.selectCell(i, j);
			} else {
				field.deselectCell();
			}
		}
	}
	
}
