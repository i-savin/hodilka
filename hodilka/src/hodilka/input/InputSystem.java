package hodilka.input;


public class InputSystem {

	private InputSource inputSource;
	
	public InputSystem(InputSource inputSource) {
		this.inputSource = inputSource;
	}

	public PlayerInput getUserInputNoWait() {
		return inputSource.getInput();
	}
	
	/** Stops the thread until player pushes a keyboard button */
	public PlayerInput getUserInputWithWait() {
		PlayerInput ui = inputSource.getInput();
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
