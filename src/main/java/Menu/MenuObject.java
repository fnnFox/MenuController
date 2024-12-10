package Menu;

public abstract class MenuObject {
	private final String name;
	private final MenuObject parent;
	public MenuObject(String name, MenuObject parent) {
		this.name = name;
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public MenuObject getParent() {
		return parent;
	}
}
