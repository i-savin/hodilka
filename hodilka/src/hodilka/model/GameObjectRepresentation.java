package hodilka.model;

import hodilka.Constants;

import java.awt.Color;
import java.awt.Image;

public class GameObjectRepresentation {
	public static final GameObjectRepresentation EMPTY = new GameObjectRepresentation();
	private char sign;
	private Color color;
	private Image image;
	
	public GameObjectRepresentation() {
		this.sign = Constants.CLEAR_SYMBOL.getValue();
		this.color = Color.WHITE;
	}
	
	public GameObjectRepresentation(char sign, Color color) {
		this.sign = sign;
		this.color = color;
	}
	public char getSign() {
		return sign;
	}
	public void setSign(char sign) {
		this.sign = sign;
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
