package Menu;

import java.util.HashMap;

public class MenuCreator {
	private final HashMap<String, MenuPage> pageMap = new HashMap<>();

	public MenuPage addPage(String name) {
		MenuPage page = new MenuPage(name);
		pageMap.put(page.getName(), page);
		return page;
	}
	public MenuPage getPage(String name) {
		return pageMap.get(name);
	}
	public HashMap<String, MenuPage> getPageMap() {
		return pageMap;
	}
}
