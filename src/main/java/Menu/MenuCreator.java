package Menu;

import java.util.HashMap;

public class MenuCreator extends MenuObject {
	private static int counter = 0;
	private final HashMap<String, MenuPage> pageMap = new HashMap<>();
	private MenuController controller;

	public MenuCreator() {
		super("creator"+(counter++),null);
	}

	public MenuPage addPage(String name) {
		MenuPage page = new MenuPage(name,this);
		pageMap.put(page.getName(), page);
		return page;
	}
	public MenuPage getPage(String name) {
		return pageMap.get(name);
	}
	public HashMap<String, MenuPage> getPageMap() {
		return pageMap;
	}

	public void setController(MenuController controller) {
		this.controller = controller;
	}
	public MenuController getController() {
		return controller;
	}
}
