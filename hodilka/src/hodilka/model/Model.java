package hodilka.model;

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
		
		mouseX -= (screenWidthInPixels - field.getWigthInCells() * 40) / 2 - 5;
		mouseY -= (screenHeightInPixels - field.getHeightInCells() * 40) / 2 - 30;
		
		int j = mouseX / 40;
		int i = mouseY / 40;
		field.selectCell(i, j);
	}
	
}
