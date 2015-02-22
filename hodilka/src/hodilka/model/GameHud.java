package hodilka.model;

import java.awt.Image;

public class GameHud {
	public Image img;
	
	public int widthInPixels;
	public int heightInPixels;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getWidthInPixels() {
		return widthInPixels;
	}

	public void setWidthInPixels(int widthInPixels) {
		this.widthInPixels = widthInPixels;
	}

	public int getHeightInPixels() {
		return heightInPixels;
	}

	public void setHeightInPixels(int heightInPixels) {
		this.heightInPixels = heightInPixels;
	}
	
}
