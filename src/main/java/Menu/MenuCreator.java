package Menu;

import java.util.HashMap;

public class MenuCreator {
	private final HashMap<String, MenuPage> pageMap = new HashMap<>();
	private MenuPage currentPage;

	public void addPage(String name, String title) {
		MenuPage page = new MenuPage(title);
		pageMap.put(name, page);
		currentPage = page;
	}
	public void selectPage(String title) {
		MenuPage page = pageMap.get(title);
		if (page != null) {
			currentPage = page;
		}
	}
	public void addItemsToSelectedPage(MenuItem item) {
		currentPage.addItem(item);
	}
	public HashMap<String, MenuPage> getPageMap() {
		return pageMap;
	}
}
