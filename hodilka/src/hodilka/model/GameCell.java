package hodilka.model;

import hodilka.Constants;

import java.util.LinkedList;
import java.util.List;

public class GameCell {
	private final List<GameObject> gameObjects = new LinkedList<GameObject>();
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}

	public char getRepresentation() {
		if (gameObjects.isEmpty()) {
			return Constants.CLEAR_SYMBOL.getValue();
		} else {
			return gameObjects.get(gameObjects.size() - 1).getRepresentation().getSign();
		}
	}
}
