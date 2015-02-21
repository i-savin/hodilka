package hodilka.model;

public class Model {
	
	private GameObject player;
	
	private GameField field;
	private GameHud hud;
	private MainMenu menu;
	private Inventory inventory;
	
	public Model() {
	}

	public GameField getField() {
		return field;
	}

	public void setField(GameField field) {
		this.field = field;
	}

	public GameObject getPlayer() {
		return player;
	}

	public void setPlayer(GameObject player) {
		this.player = player;
	}

	public void actualizeViewPortSize(int screenWidthInPixels, int screenHeightInPixels) {
		
	}

	public void checkSelection(int mouseX, int mouseY, int screenWidthInPixels, int screenHeightInPixels) {
		
		mouseX -= (screenWidthInPixels - field.getWigthInCells() * 40) / 2;
		mouseY -= (screenHeightInPixels - field.getHeightInCells() * 40) / 2;
		
		int j = mouseX / 40;
		int i = mouseY / 40;
		field.selectCell(i, j);
	}
	
}
