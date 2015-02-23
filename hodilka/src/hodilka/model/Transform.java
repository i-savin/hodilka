package hodilka.model;

public class Transform {
	private int x;
	private int y;
	
	private Rotation roration;
	
	public int getY() {
		return x;
	}
	public void setY(int verticalCord) {
		this.x = verticalCord;
	}
	public int getX() {
		return y;
	}
	public void setX(int horizontalCord) {
		this.y = horizontalCord;
	}

	public Rotation getRoration() {
		return roration;
	}

	public void setRoration(Rotation roration) {
		this.roration = roration;
	}
	
}
