public class Print {
	private String text;

	public Print(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void print() {
		text = getText();

		System.out.println(text);
	}
}
