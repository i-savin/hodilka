package hodilka.model;

import java.util.LinkedList;
import java.util.List;

public class FieldCell {
	private final List<GameObject> gameObjects = new LinkedList<GameObject>();
	
	public void addGameObject(GameObject gameObject) {
		gameObjects.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjects.remove(gameObject);
	}

	public GameObjectRepresentation getRepresentation() {
		if (gameObjects.isEmpty()) {
			return GameObjectRepresentation.EMPTY;
		} else {
			return gameObjects.get(gameObjects.size() - 1).getRepresentation();
		}
	}
}