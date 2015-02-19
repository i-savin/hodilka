package hodilka.input;


public class InputSystem {

	private KeyInputSource inputSource;
	
	public InputSystem(KeyInputSource inputSource) {
		this.inputSource = inputSource;
	}

	public PlayerKeyInput getUserInputNoWait() {
		return inputSource.getInput();
	}
	
	/** Stops the thread until player pushes a keyboard button */
	public PlayerKeyInput getUserInputWithWait() {
		PlayerKeyInput ui = inputSource.getInput();
		if (ui.isEmpty()) {
			synchronized (inputSource) {
				try {
					inputSource.wait();
					ui = inputSource.getInput();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return ui;
	}
}
