package hodilka.input;

public class PlayerInput {

	private final boolean empty;
	private final int keyCode;
	private final int modifiers;

	public PlayerInput() {
		this.empty = true;
		this.keyCode = 0;
		this.modifiers = 0;
	}

	public PlayerInput(int keyCode, int modifiers) {
		this.empty = false;
		this.keyCode = keyCode;
		this.modifiers = modifiers;
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public int getKeyCode() {
		return keyCode;
	}

	public int getModifiers() {
		return modifiers;
	}

}
