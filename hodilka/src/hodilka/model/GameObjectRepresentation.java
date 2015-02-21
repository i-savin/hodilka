package hodilka.model;

import java.awt.Color;
import java.awt.Image;

public class GameObjectRepresentation {
	public static final GameObjectRepresentation EMPTY = new GameObjectRepresentation();
	private Color color;
	private Image image;
	
	public GameObjectRepresentation() {
		this.color = Color.WHITE;
	}
	
	public GameObjectRepresentation(char sign, Color color) {
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}
