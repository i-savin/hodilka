package hodilka.model;

import hodilka.ImageConstants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ModelGenerator {

	public static Image sellSelection;
	static {
		try {
			sellSelection = ImageIO.read(ModelGenerator.class.getResourceAsStream("/cellSelection.png")).getScaledInstance(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, Image.SCALE_SMOOTH);
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
		
		model.setHud(generateHud());
		
		model.setInventory(generateInventory());
		
		return model;
	}

	private Player generatePlayer() {
		Player player = new Player();
		
		GameObject playerGameObject = new GameObject();
		playerGameObject.getRepresentation().setColor(Color.RED);
		try {
			
			Image playerIm = new BufferedImage(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, BufferedImage.TYPE_INT_ARGB);
			Graphics g = playerIm.getGraphics();			
			
			Image playerBody = ImageIO.read(ModelGenerator.class.getResourceAsStream("/player.png")).getScaledInstance(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, Image.SCALE_SMOOTH);
			Image sword = ImageIO.read(ModelGenerator.class.getResourceAsStream("/sword.png")).getScaledInstance(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, Image.SCALE_SMOOTH);
			Image shild = ImageIO.read(ModelGenerator.class.getResourceAsStream("/shild.png")).getScaledInstance(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, Image.SCALE_SMOOTH);
			
			g.drawImage(playerBody, 0, 0, null);
			g.drawImage(sword, 0, 0, null);
			g.drawImage(shild, 0, 0, null);
			
			playerGameObject.getRepresentation().setImage(playerIm);
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
			groundImage = ImageIO.read(ModelGenerator.class.getResourceAsStream("/ground.png")).getScaledInstance(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, Image.SCALE_SMOOTH);
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
				
				field.getCell(i, j).addGameObject(ground);
			}
		}
		
		field.setHeightInPixels(heightInCells * ImageConstants.IMAGE_WH);
		field.setWidthInPixels(widthInCells * ImageConstants.IMAGE_WH);
		
		return field;
	}

	private GameHud generateHud() {
		GameHud hud = new GameHud();
		
		Image hudImage = null;
		try {
			hudImage = ImageIO.read(ModelGenerator.class.getResourceAsStream("/hud.png")).getScaledInstance(400, 80, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hud.setImg(hudImage);
		
		hud.setWidthInPixels(400);
		hud.setHeightInPixels(80);
		
		return hud;
	}
	
	private Inventory generateInventory() {
		Inventory inventory = new Inventory();
		
		Image inventoryImage = null;
		try {
			inventoryImage = ImageIO.read(ModelGenerator.class.getResourceAsStream("/inventory.png")).getScaledInstance(600, 400, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inventory.setImg(inventoryImage);
		
		inventory.setWidthInPixels(600);
		inventory.setHeightInPixels(400);
		
		return inventory;
	}
}
