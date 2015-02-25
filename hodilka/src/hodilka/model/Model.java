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

	public void checkSelection(int mouseX, int mouseY, int screenWidthInPixels, int screenHeightInPixels) {
		
		// field centred camera: begin
//		mouseX -= (screenWidthInPixels - field.getWigthInCells() * 40) / 2 - 5;
//		mouseY -= (screenHeightInPixels - field.getHeightInCells() * 40) / 2 - 30;
		// field centred camera: end
		
		// player centred camera: begin
		int playerX = player.getGameObject().getLocationCell().getJ() * ImageConstants.IMAGE_WH + ImageConstants.IMAGE_WH / 2;
		int playerY = player.getGameObject().getLocationCell().getI() * ImageConstants.IMAGE_WH + ImageConstants.IMAGE_WH / 2;

		int screenCenterX = screenWidthInPixels / 2;
		int screenCenterY = screenHeightInPixels / 2;
		
		// FIXME 5, 30 - толщина рамок окна
		int mouseXOffset = playerX - (screenCenterX - mouseX) + 5;
		int mouseYOffset = playerY - (screenCenterY - mouseY) + 30;
		// player centred camera: end
		
		// if mouse over the field
		if (mouseXOffset > 0 && mouseYOffset > 0 && mouseXOffset <= field.getWidthInPixels() && mouseYOffset <= field.getHeightInPixels()) {
			int j = mouseXOffset / ImageConstants.IMAGE_WH;
			int i = mouseYOffset / ImageConstants.IMAGE_WH;
			field.selectCell(i, j);
		} else {
			field.deselect();
		}

	}
	
}
