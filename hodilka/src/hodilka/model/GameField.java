package hodilka.model;

import hodilka.exceptions.ValidationException;

public class GameField {
	private final GameCell[][] cells;
	private final int wigthInCells;
	private final int heightInCells;
	
	private GameCell selectedCell;
	
	public GameField(int width, int height) {
		this.wigthInCells = width;
		this.heightInCells = height;
		cells = new GameCell[this.heightInCells][this.wigthInCells];
		for (GameCell[] line: cells) {
			for (int k = 0; k < line.length; k++) {
				line[k] = new GameCell();
			}
		}
		
		selectCell(0, 0);
	}
	
	public void selectCell(int x, int y) {
		validateCoordinates(x, y);
		selectedCell = cells[x][y];
	}
	
	public GameCell getSelectedCell() {
		return selectedCell;
	}

	public void setCell(int i, int j, GameCell cell) {
		validateCoordinates(i, j);
		if (selectedCell == cells[i][j]) {
			selectedCell = cell;
		}
		cells[i][j] = cell;
	}
	
	private void validateCoordinates(int i, int j) {
		if (0 > i && i >= heightInCells && 0 > j && j >= wigthInCells) {
			throw new ValidationException("Wrong (i, j) == (" + i + "," + j + ")");
		}
	}

	public char[][] getReprezentation() {
		char[][] rep = new char[heightInCells][wigthInCells];
		for (int i = 0; i < heightInCells; i++) {
			for (int j = 0; j < wigthInCells; j++) {
				rep[i][j] = cells[i][j].getRepresentation();
			}
		}
		return rep;
	}

	public GameCell getCell(int i, int j) {
		validateCoordinates(i, j);
		return cells[i][j];
	}
	
}
