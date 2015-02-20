package hodilka.model;

import hodilka.exceptions.ValidationException;

public class GameField {
	private final FieldCell[][] cells;
	private final int wigthInCells;
	private final int heightInCells;
	
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
		
		selectCell(0, 0);
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

	public GameObjectRepresentation[][] getReprezentation() {
		GameObjectRepresentation rep[][] = new GameObjectRepresentation[heightInCells][wigthInCells];
		for (int i = 0; i < heightInCells; i++) {
			for (int j = 0; j < wigthInCells; j++) {
				rep[i][j] = cells[i][j].getRepresentation();
			}
		}
		return rep;
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
	
}
