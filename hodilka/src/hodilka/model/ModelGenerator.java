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
		return model;
	}

	private GameObject generatePlayer() {
		GameObject player = new GameObject();
		player.getRepresentation().setSign('@');
		player.getRepresentation().setColor(Color.RED);
		try {
			player.getRepresentation().setImage(ImageIO.read(ModelGenerator.class.getResourceAsStream("/player.png")).getScaledInstance(237/3, 479/3, Image.SCALE_SMOOTH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.setTransform(new Transform());
		player.getTransform().setHorizontalCord(250);
		player.getTransform().setVerticalCord(200);
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
			}
		}
		
		return field;
	}
	
}
