package hodilka;

public enum Constants {
	CLEAR_SYMBOL(' '), HORIZONTAL('='), VERTICAL('|'), CORNER('+'), END_OF_LINE('\n');
	
	private char c;
	Constants(char c) {
		this.c = c;
	}
	public char getValue() {
		return c;
	}
}
