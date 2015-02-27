package hodilka.model;

import hodilka.ImageConstants;
import hodilka.resource.ResourceManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ModelGenerator {

	// FIXME: hardcoded
	private int fieldHeightInCells = 20;
	private int fieldWidthInCells = 20;
	
	private final ResourceManager resourceManager;
	
	public ModelGenerator(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
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
		Image playerIm = new BufferedImage(ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH, BufferedImage.TYPE_INT_ARGB);
		Graphics g = playerIm.getGraphics();			

		Image playerBody = this.resourceManager.findPNG("/player", ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH);
		Image sword = this.resourceManager.findPNG("/sword", ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH);
		Image shild = this.resourceManager.findPNG("/shild", ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH);
		
		g.drawImage(playerBody, 0, 0, null);
		g.drawImage(sword, 0, 0, null);
		g.drawImage(shild, 0, 0, null);
		
		playerGameObject.getRepresentation().setImage(playerIm);
		playerGameObject.setTransform(new Transform());
		player.setGameObject(playerGameObject);
		
		return player;
	}

	private GameField generateGameField() {
		Image groundImage = this.resourceManager.findPNG("/ground", ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH);
		
		GameField field = new GameField(fieldWidthInCells, fieldHeightInCells);
		for (int i = 0; i < fieldHeightInCells; i++) {
			for (int j = 0; j < fieldWidthInCells; j++) {
				
				GameObject ground = new GameObject();
				ground.setDiscription("Ground");
				ground.setRepresentation(new GameObjectRepresentation());
				ground.getRepresentation().setImage(groundImage);
				
				field.getCell(i, j).addGameObject(ground);
			}
		}
		
		field.setHeightInPixels(fieldHeightInCells * ImageConstants.IMAGE_WH);
		field.setWidthInPixels(fieldWidthInCells * ImageConstants.IMAGE_WH);
		
		GameObject cellSelectionMark = new GameObject();
		cellSelectionMark.setRepresentation(new GameObjectRepresentation());
		cellSelectionMark.getRepresentation().setImage(this.resourceManager.findPNG("/cellSelection", ImageConstants.IMAGE_WH, ImageConstants.IMAGE_WH));
		field.setCellSelectionMark(cellSelectionMark);
		
		return field;
	}

	private GameHud generateHud() {
		GameHud hud = new GameHud();
		
		Image hudImage = this.resourceManager.findPNG("/hud", 400, 80);
		
		hud.setImg(hudImage);
		
		hud.setWidthInPixels(400);
		hud.setHeightInPixels(80);
		
		return hud;
	}
	
	private Inventory generateInventory() {
		Inventory inventory = new Inventory();
		
		Image inventoryImage = this.resourceManager.findPNG("/inventory", 600, 400);
		
		inventory.setImg(inventoryImage);
		
		inventory.setWidthInPixels(600);
		inventory.setHeightInPixels(400);
		
		return inventory;
	}
}
