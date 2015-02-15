package hodilka.input;


public class InputSystem {

	private InputSource inputSource;
	
	public InputSystem(InputSource inputSource) {
		this.inputSource = inputSource;
	}

	public UserInput getInputNoWait() {
		return inputSource.getInput();
	}
	
	public UserInput getInputWithWait() {
		UserInput ui = inputSource.getInput();
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
