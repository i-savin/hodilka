package hodilka.model;

import hodilka.exceptions.ValidationException;

public class GameField {
	private final FieldCell[][] cells;
	
	private final int wigthInCells;
	private final int heightInCells;

	private int offsetOnXInPixels;
	private int offsetOnYInPixels;
	
	private int widthInPixels;
	private int heightInPixels;
	
	private FieldCell selectedCell;
	
	public GameField(int widthInCells, int heightInCells) {
		
		this.wigthInCells = widthInCells;
		this.heightInCells = heightInCells;
		
		cells = new FieldCell[this.heightInCells][this.wigthInCells];
		
		for (int i = 0; i < heightInCells; i++) {
			for (int j = 0; j < wigthInCells; j++) {
				cells[i][j] = new FieldCell(i, j);
				
				FieldCell cell = cells[i][j];
				
				if (0 <= j - 1) {
					cell.setLeftCell(cells[i][j - 1]);
					cells[i][j - 1].setRightCell(cell);
				}
				
				if (0 <= i - 1) {
					cell.setUpCell(cells[i - 1][j]);
					cells[i - 1][j].setDownCell(cell);
				}
				
				if (0 <= i - 1 && 0 <= j - 1) {
					cell.setLeftUpCell(cells[i - 1][j - 1]);
					cells[i - 1][j - 1].setRightDownCell(cell);
				}
				
				if (0 <= i - 1 && j + 1 < widthInCells) {
					cell.setRightUpCell(cells[i - 1][j + 1]);
					cells[i - 1][j + 1].setLeftDownCell(cell);
				}
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

	public void deselectCell() {
		if (selectedCell != null) {
			selectedCell.setSelected(false);
			selectedCell = null;
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

	public int getOffsetOnXInPixels() {
		return offsetOnXInPixels;
	}

	public void setOffsetOnXInPixels(int offsetOnXInPixels) {
		this.offsetOnXInPixels = offsetOnXInPixels;
	}

	public int getOffsetOnYInPixels() {
		return offsetOnYInPixels;
	}

	public void setOffsetOnYInPixels(int offsetOnYInPixels) {
		this.offsetOnYInPixels = offsetOnYInPixels;
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

	/** If mouse is over the field or not (true - over, false - some where else). mouseXRelative, mouseYRelative relative to field's (0,0) upper left point */
	public boolean isMouseOver(int mouseXRelative, int mouseYRelative) {
		return mouseXRelative > 0 && mouseYRelative > 0 && mouseXRelative <= widthInPixels && mouseYRelative <= heightInPixels;
	}
	
}
