package hodilka.output.swing.graphical;

import java.awt.Graphics;

import hodilka.model.Model;

public interface ModelRender {
	void render(Model model, Graphics screenGraphics, int widthInPixels, int heghtInPixels);
}