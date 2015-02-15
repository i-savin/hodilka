package hodilka.model;

import java.awt.Color;

public class ModelGenerator {

	public Model createModel() {
		Model model = new Model(100, 80);
		model.setField(generateGameField());
		model.setPlayer(generatePlayer());
		return model;
	}

	private GameObject generatePlayer() {
		GameObject player = new GameObject();
		player.getRepresentation().setSign('@');
		player.getRepresentation().setColor(Color.RED);
		player.setTransform(new Transform());
		player.getTransform().setHorizontalCord(10);
		player.getTransform().setVerticalCord(20);
		return player;
	}

	private GameField generateGameField() {
		// FIXME: hardcoded
		GameField field = new GameField(100, 80);
		return field;
	}
	
}
