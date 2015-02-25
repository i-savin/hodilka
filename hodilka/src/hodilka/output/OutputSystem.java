package hodilka.output;

public class OutputSystem {
	
	private OutputInterface consoleInterface;
	private long lastRendered;
	
	public OutputSystem(OutputInterface consoleInterface) {
		this.consoleInterface = consoleInterface;
		lastRendered = System.currentTimeMillis();
	}
	
	public void render() {
		if (System.currentTimeMillis() - lastRendered > 30) {
			
			consoleInterface.clear();
			
			consoleInterface.draw();
			
			consoleInterface.flush();
			
			lastRendered = System.currentTimeMillis();
		}
	}
}
