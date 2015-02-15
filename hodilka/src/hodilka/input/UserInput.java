package hodilka.input;

public class UserInput {

	private final boolean empty;
	private final int keyCode;
	private final int modifiers;

	public UserInput() {
		this.empty = true;
		this.keyCode = 0;
		this.modifiers = 0;
	}

	public UserInput(int keyCode, int modifiers) {
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
