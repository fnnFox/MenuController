package Messages;

public enum Messages {
	INDEX_OUT_OF_BOUNDS("Inserted number is out of bounds. Try again."),
	INCORRECT_INPUT("Incorrect input. Try again.");

	private String message;
	Messages(String message){
		this.message = message;
	}

	public static void changeMessage(Messages message, String string) {
		message.message = string;
	}
	@Override
	public String toString() {
		return message;
	}
}
