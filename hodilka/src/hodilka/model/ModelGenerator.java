package hodilka.model;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ModelGenerator {

	public static Image sellSelection;
	static {
		try {
			sellSelection = ImageIO.read(ModelGenerator.class.getResourceAsStream("/cellSelection.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Model createModel() {
		Model model = new Model();
		model.setField(generateGameField());
		model.setPlayer(generatePlayer());
		
		model.getField().getCell(5, 5).addGameObject(model.getPlayer().getGameObject());
		
		return model;
	}

	private Player generatePlayer() {
		Player player = new Player();
		
		GameObject playerGameObject = new GameObject();
		playerGameObject.getRepresentation().setColor(Color.RED);
		try {
			playerGameObject.getRepresentation().setImage(ImageIO.read(ModelGenerator.class.getResourceAsStream("/player.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playerGameObject.setTransform(new Transform());
		player.setGameObject(playerGameObject);
		
		return player;
	}

	private GameField generateGameField() {
		// FIXME: hardcoded
		int heightInCells = 20;
		int widthInCells = 20;
		
		Image groundImage = null;
		try {
			groundImage = ImageIO.read(ModelGenerator.class.getResourceAsStream("/ground.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GameField field = new GameField(widthInCells, heightInCells);
		for (int i = 0; i < heightInCells; i++) {
			for (int j = 0; j < widthInCells; j++) {
				
				GameObject ground = new GameObject();
				ground.setDiscription("Ground");
				ground.setRepresentation(new GameObjectRepresentation());
				ground.getRepresentation().setImage(groundImage);
				
				FieldCell cell = new FieldCell();
				cell.addGameObject(ground);
				field.setCell(i, j, cell);
				
				if (0 <= j - 1) {
					cell.setLeftCell(field.getCell(i, j - 1));
					field.getCell(i, j - 1).setRightCell(cell);
				}
				
				if (0 <= i - 1) {
					cell.setUpCell(field.getCell(i - 1, j));
					field.getCell(i - 1, j).setDownCell(cell);
				}
			}
		}
		
		return field;
	}
	
}
