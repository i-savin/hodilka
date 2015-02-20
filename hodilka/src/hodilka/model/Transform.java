package hodilka.model;

public class Transform {
	private int verticalCord;
	private int horizontalCord;
	
	private Rotation roration;
	private int STEP_SIZE = 40;
	
	public void moveTo(int i, int j) {
		this.verticalCord = i;
		this.horizontalCord = j;
	}
	
	public void moveLeft(int howMuch) {
		this.horizontalCord -= howMuch;
	}
	
	public void moveLeft() {
		moveLeft(STEP_SIZE);
	}
	
	public void moveRight(int howMuch) {
		this.horizontalCord += howMuch;
	}
	
	public void moveRight() {
		moveRight(STEP_SIZE);
	}
	
	public void moveUp(int howMuch) {
		this.verticalCord -= howMuch;
	}
	
	public void moveUp() {
		moveUp(STEP_SIZE );
	}
	
	public void moveDown(int howMuch) {
		this.verticalCord += howMuch;
	}
	
	public void moveDown() {
		moveDown(STEP_SIZE);
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
