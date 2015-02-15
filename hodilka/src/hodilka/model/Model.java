package hodilka.model;

public class Model {

	private int widthInCells;
	private int heightInCells;
	private GameObject player;
	
	private GameField field;
	private GameHud hud;
	
	public Model(int widthInCells, int heightInCells) {
		this.widthInCells = widthInCells;
		this.heightInCells = heightInCells;
	}

	public int getWidthInCells() {
		return widthInCells;
	}

	public void setWidthInCells(int widthInCells) {
		this.widthInCells = widthInCells;
	}

	public int getHeightInCells() {
		return heightInCells;
	}

	public void setHeightInCells(int heightInCells) {
		this.heightInCells = heightInCells;
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

	public char[][] getReprezentation() {
		char[][] rep = field.getReprezentation();
		rep[player.getTransform().getVerticalCord()][player.getTransform().getHorizontalCord()] = player.getRepresentation().getSign();
		return rep;
	}

}
