package hodilka.input;

/** Implicit shared data */
public class PlayerInput {

	private boolean keyPressed;
	private int keyCode;
	private int modifiers;
	
	private boolean mouseMoved;
	private int mouseX;
	private int mouseY;

	private boolean mouseButtonChanged;
	public int button;
	
	public boolean isEmpty() {
		// TODO shuffle expr parts in order of occurrence rate to achieve better performance
		return !keyPressed && !mouseMoved && !mouseButtonChanged;
	}
	
	public boolean isKeyPressed() {
		return keyPressed;
	}
	public void setKeyPressed(boolean keyPressed) {
		this.keyPressed = keyPressed;
	}
	public int getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}
	public int getModifiers() {
		return modifiers;
	}
	public void setModifiers(int modifiers) {
		this.modifiers = modifiers;
	}
	public boolean isMouseMoved() {
		return mouseMoved;
	}
	public void setMouseMoved(boolean mouseMoved) {
		this.mouseMoved = mouseMoved;
	}
	public int getMouseX() {
		return mouseX;
	}
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	public boolean isMouseButtonChanged() {
		return mouseButtonChanged;
	}
	public void setMouseButtonChanged(boolean mouseButtonChanged) {
		this.mouseButtonChanged = mouseButtonChanged;
	}
	public int getButton() {
		return button;
	}
	public void setButton(int button) {
		this.button = button;
	}
	public void cleanFlags() {
		keyPressed = false;
		mouseMoved = false;
		mouseButtonChanged = false;
	}

	@Override
	public String toString() {
		return "PlayerInput [keyPressed=" + keyPressed + ", keyCode=" + keyCode
				+ ", modifiers=" + modifiers + ", mouseMoved=" + mouseMoved
				+ ", mouseX=" + mouseX + ", mouseY=" + mouseY
				+ ", mouseButtonChanged=" + mouseButtonChanged + ", button="
				+ button + "]";
	}
	
}
