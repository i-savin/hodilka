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

	public void moveLeftUp() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell leftUp = cell.getLeftUpCell();
		if (leftUp != null) {
			cell.removeGameObject(gameObject);
			leftUp.addGameObject(gameObject);
		}
	}

	public void moveLeftDown() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell leftDown = cell.getLeftDownCell();
		if (leftDown != null) {
			cell.removeGameObject(gameObject);
			leftDown.addGameObject(gameObject);
		}
	}

	public void moveRightUp() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell rightUp = cell.getRightUpCell();
		if (rightUp != null) {
			cell.removeGameObject(gameObject);
			rightUp.addGameObject(gameObject);
		}
	}

	public void moveRightDown() {
		FieldCell cell = gameObject.getLocationCell();
		FieldCell rightDown = cell.getRightDownCell();
		if (rightDown != null) {
			cell.removeGameObject(gameObject);
			rightDown.addGameObject(gameObject);
		}
	}

}
