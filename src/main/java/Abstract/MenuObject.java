package Abstract;

public abstract class MenuObject {
	private final String name;
	private final MenuObject container;
	public MenuObject(String name, MenuObject container) {
		this.name = name;
		this.container = container;
	}
	public String getName() {
		return name;
	}
	public MenuObject getContainer() {
		return container;
	}
}
