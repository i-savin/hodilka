package hodilka.model;

public class Model {

	private int widthInChars;
	private int heightInChars;
	private GameObject player;
	
	private GameField field;
	private GameHud hud;
	
	public Model(int widthInChars, int heightInChars) {
		this.widthInChars = widthInChars;
		this.heightInChars = heightInChars;
	}

	public int getWidthInChars() {
		return widthInChars;
	}

	public void setWidthInChars(int widthInChars) {
		this.widthInChars = widthInChars;
	}

	public int getHeightInChars() {
		return heightInChars;
	}

	public void setHeightInChars(int heightInChars) {
		this.heightInChars = heightInChars;
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
