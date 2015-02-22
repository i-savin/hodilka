package hodilka.model;

import hodilka.exceptions.ValidationException;

public class GameField {
	private final FieldCell[][] cells;
	
	private final int wigthInCells;
	private final int heightInCells;
	
	private int widthInPixels;
	private int heightInPixels;
	
	private FieldCell selectedCell;
	
	public GameField(int widthInCells, int heightInCells) {
		
		this.wigthInCells = widthInCells;
		this.heightInCells = heightInCells;
		
		cells = new FieldCell[this.heightInCells][this.wigthInCells];
		
		for (FieldCell[] line: cells) {
			for (int k = 0; k < line.length; k++) {
				line[k] = new FieldCell();
			}
		}
	}
	
	public void selectCell(int i, int j) {
		if (areValidCoordinates(i, j)) {
			if (selectedCell != null) {
				selectedCell.setSelected(false);
			}
			selectedCell = cells[i][j];
			selectedCell.setSelected(true);
		}
	}

	public FieldCell getSelectedCell() {
		return selectedCell;
	}

	public void setCell(int i, int j, FieldCell cell) {
		validateCoordinates(i, j);
		if (selectedCell == cells[i][j]) {
			selectedCell.setSelected(false);
			selectedCell = cell;
			selectedCell.setSelected(true);
		}
		cells[i][j] = cell;
	}
	
	private void validateCoordinates(int i, int j) {
		if (0 > i && i >= heightInCells && 0 > j && j >= wigthInCells) {
			throw new ValidationException("Wrong (i, j) == (" + i + "," + j + ")");
		}
	}
	
	private boolean areValidCoordinates(int i, int j) {
		return 0 <= i && i < heightInCells && 0 <= j && j < wigthInCells;
	}

	public FieldCell getCell(int i, int j) {
		validateCoordinates(i, j);
		return cells[i][j];
	}

	public int getWigthInCells() {
		return wigthInCells;
	}

	public int getHeightInCells() {
		return heightInCells;
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
