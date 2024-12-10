package Menu;

public abstract class MenuObject {
	private final String name;
	public MenuObject(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
