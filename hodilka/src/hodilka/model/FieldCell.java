package hodilka.model;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class FieldCell {
	private final List<GameObject> gameObjectStack = new LinkedList<GameObject>();
	
	private boolean selected;
	
	public void addGameObject(GameObject gameObject) {
		gameObjectStack.add(gameObject);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjectStack.remove(gameObject);
	}
	
	public void pushGameObject(GameObject gameObject) {
		gameObjectStack.add(0, gameObject);
	}
	
	public GameObject popGameObject() {
		return gameObjectStack.remove(0);
	}

	public GameObjectRepresentation getRepresentation() {
		if (gameObjectStack.isEmpty()) {
			return GameObjectRepresentation.EMPTY;
		} else {
			return gameObjectStack.get(gameObjectStack.size() - 1).getRepresentation();
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void render(Graphics graphicContext, int x, int y) {
		graphicContext.drawImage(gameObjectStack.get(gameObjectStack.size() - 1).getRepresentation().getImage(), x, y, null);
		if (selected) {
			graphicContext.drawImage(ModelGenerator.sellSelection, x, y, null);
		}
	}
	
}
