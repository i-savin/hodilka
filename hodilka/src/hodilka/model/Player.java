package hodilka.model;

public class Player {
	private GameObject gameObject;

	public GameObject getGameObject() {
		return gameObject;
	}

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}

	public void moveLeft() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell left = cell.getLeftCell();
		if (left != null) {
			cell.removeGameObject(gameObject);
			left.addGameObject(gameObject);
		}
		
	}

	public void moveUp() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell up = cell.getUpCell();
		if (up != null) {
			cell.removeGameObject(gameObject);
			up.addGameObject(gameObject);
		}
	}

	public void moveRight() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell right = cell.getRightCell();
		if (right != null) {
			cell.removeGameObject(gameObject);
			right.addGameObject(gameObject);
		}
	}

	public void moveDown() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell down = cell.getDownCell();
		if (down != null) {
			cell.removeGameObject(gameObject);
			down.addGameObject(gameObject);
		}
	}

}
