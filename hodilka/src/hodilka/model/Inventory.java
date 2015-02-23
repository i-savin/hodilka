package hodilka.model;

import java.awt.Image;

public class Inventory {
	
	private boolean opend;
	
	private Image img;
	
	private int widthInPixels;
	private int heightInPixels;

	public boolean isOpend() {
		return opend;
	}

	public void setOpend(boolean opend) {
		this.opend = opend;
	}

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
