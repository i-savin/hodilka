package hodilka.model;

public class Transform {
	private int verticalCord;
	private int horizontalCord;
	
	private Rotation roration;
	
	public void moveTo(int i, int j) {
		this.verticalCord = i;
		this.horizontalCord = j;
	}
	
	public void moveLeft(int howMuch) {
		this.horizontalCord -= howMuch;
	}
	
	public void moveLeft() {
		moveLeft(80);
	}
	
	public void moveRight(int howMuch) {
		this.horizontalCord += howMuch;
	}
	
	public void moveRight() {
		moveRight(80);
	}
	
	public void moveUp(int howMuch) {
		this.verticalCord -= howMuch;
	}
	
	public void moveUp() {
		moveUp(80);
	}
	
	public void moveDown(int howMuch) {
		this.verticalCord += howMuch;
	}
	
	public void moveDown() {
		moveDown(80);
	}
	
	public int getVerticalCord() {
		return verticalCord;
	}
	public void setVerticalCord(int verticalCord) {
		this.verticalCord = verticalCord;
	}
	public int getHorizontalCord() {
		return horizontalCord;
	}
	public void setHorizontalCord(int horizontalCord) {
		this.horizontalCord = horizontalCord;
	}

	public Rotation getRoration() {
		return roration;
	}

	public void setRoration(Rotation roration) {
		this.roration = roration;
	}
	
}
