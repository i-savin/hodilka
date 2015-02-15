package hodilka;

public class Window {

	private int leftUpperI;
	private int leftUpperJ;
	private int width;
	private int height;
	private String title;
	private int layer;
	private char[][] buffer;
	
	public Window(int leftUpperI, int leftUpperJ, int width, int height, String title) {
		this.leftUpperI = leftUpperI;
		this.leftUpperJ = leftUpperJ;
		this.width = width;
		this.height = height;
		this.title = title;
		buffer = new char[height][width];
		clear();
	}

	public void clear() {
		
		int spacesBeforeTitle = (width - title.length()) / 2;
		int titleLength = title.length();
		int spacesAfterTitle = (width - title.length() - 2) / 2;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Чертим рамку заголовком и с пустым местом внутри
				//
				// +----------------------+
				// |        Hello!        |
				// +----------------------+
				// |                      |
				// |                      |
				// |                      |
				// +----------------------+
				//
				
				if (i == 2 && j == 0 || i == 2 && j == width -1) {
					buffer[i][j] = Constants.CORNER.getValue();
				} else if (i == 0 && j == 0 || i == 0 && j == width -1 || i == height - 1 && j == 0 || i == height - 1 && j == width -1) {
					buffer[i][j] = Constants.CORNER.getValue();
				} else if (i == 0 || i == height - 1 || i == 2) {
					buffer[i][j] = Constants.HORIZONTAL.getValue();
				} else if (j == 0 || j == width - 1) {
					buffer[i][j] = Constants.VERTICAL.getValue();
				} else if (i == 1) {
					if (j == 0 || j == width - 1) {
						buffer[i][j] = Constants.VERTICAL.getValue();
					} else if (spacesBeforeTitle > 0) {
						buffer[i][j] = Constants.CLEAR_SYMBOL.getValue();
						spacesBeforeTitle--;
					} else if (spacesBeforeTitle == 0 && titleLength > 0) {
						buffer[i][j] = title.charAt(title.length() - titleLength);
						titleLength--;
					} else if (spacesAfterTitle > 0) {
						buffer[i][j] = Constants.CLEAR_SYMBOL.getValue();
						spacesAfterTitle--;
					}
				} else {
					buffer[i][j] = Constants.CLEAR_SYMBOL.getValue();
				}
			}
		}
	}
	
	public void setLayer(int newLayerNumber) {
		layer = newLayerNumber;
	}
	
	public int getLayer() {
		return layer;
	}

	public int getLeftUpperI() {
		return leftUpperI;
	}

	public void setLeftUpperI(int leftUpperX) {
		this.leftUpperI = leftUpperX;
	}

	public int getLeftUpperJ() {
		return leftUpperJ;
	}

	public void setLeftUpperJ(int leftUpperY) {
		this.leftUpperJ = leftUpperY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char getCharAt(int i, int j) {
		return buffer[i][j];
	}
}
