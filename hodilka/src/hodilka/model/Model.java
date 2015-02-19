package hodilka.model;

public class Model {

	private GameObject player;
	
	private GameField field;
	private GameHud hud;
	private MainMenu menu;
	
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

	public GameObjectRepresentation[][] getReprezentation() {
		GameObjectRepresentation[][] rep = field.getReprezentation();
		rep[player.getTransform().getVerticalCord()][player.getTransform().getHorizontalCord()] = player.getRepresentation();
		return rep;
	}

}
