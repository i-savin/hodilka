package hodilka.resource;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ResourceManager {

	private Map<String, Image> resources = new HashMap<String, Image>();
	
	public Image findPNG(String resourcePath, int imageWidth, int imageHeight) {
		Image img = resources.get(resourcePath);
		if (img == null) {
			try {
				img = ImageIO.read(ResourceManager.class.getResourceAsStream(resourcePath + ".png"));
				if (img.getWidth(null) != imageWidth || img.getHeight(null) != imageHeight) {
					img = img.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resources.put(resourcePath, img);
		}
		return img;
	}

}
