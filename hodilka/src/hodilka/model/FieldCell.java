package hodilka.model;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class FieldCell {
	// TODO replace List with LinkedList
	private final List<GameObject> gameObjectStack = new LinkedList<GameObject>();
	
	private FieldCell leftCell;
	private FieldCell rightCell;
	private FieldCell upCell;
	private FieldCell downCell;
	
	private boolean selected;
	
	public void addGameObject(GameObject gameObject) {
		gameObjectStack.add(gameObject);
		gameObject.setLocationCell(this);
	}
	
	public void removeGameObject(GameObject gameObject) {
		gameObjectStack.remove(gameObject);
		gameObject.setLocationCell(null);
	}
	
	public void pushGameObject(GameObject gameObject) {
		gameObjectStack.add(0, gameObject);
		gameObject.setLocationCell(this);
	}
	
	public GameObject popGameObject() {
		gameObjectStack.get(0).setLocationCell(null);
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

	public FieldCell getLeftCell() {
		return leftCell;
	}

	public void setLeftCell(FieldCell leftCell) {
		this.leftCell = leftCell;
	}

	public FieldCell getRightCell() {
		return rightCell;
	}

	public void setRightCell(FieldCell rightCell) {
		this.rightCell = rightCell;
	}

	public FieldCell getUpCell() {
		return upCell;
	}

	public void setUpCell(FieldCell upCell) {
		this.upCell = upCell;
	}

	public FieldCell getDownCell() {
		return downCell;
	}

	public void setDownCell(FieldCell downCell) {
		this.downCell = downCell;
	}

	public void render(Graphics graphicContext, int x, int y) {
		for (GameObject go: gameObjectStack ) {
			graphicContext.drawImage(go.getRepresentation().getImage(), x, y, null);
		}
		if (selected) {
			graphicContext.drawImage(ModelGenerator.sellSelection, x, y, null);
		}
	}
	
}
