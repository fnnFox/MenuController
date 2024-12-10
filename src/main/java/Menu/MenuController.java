package Menu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MenuController {
	private final Stack<MenuPage> menuPageStack = new Stack<>();
	private MenuPage currentPage;
	private final HashMap<String, MenuPage> menuPageMap;
	private final MenuRenderer renderer;

	private boolean isRunning;

	public MenuController(MenuCreator creator, MenuRenderer renderer, MenuPage startPage) {
		creator.setController(this);
		this.menuPageMap = creator.getPageMap();
		//this.menuPageStack.push(this.menuPageMap.get(startPage));
		this.renderer = renderer;
		this.currentPage = startPage;
	}

	public void run() throws IllegalArgumentException {
		isRunning = true;
		while (isRunning) {
			this.renderer.renderTitle(currentPage.getTitle());
			this.renderer.renderItems(currentPage.getItemList());

			while (true) {
				int index = this.renderer.getUserChoice();
				try {
					MenuPage page = this.currentPage.getItem(index).runActions();
					if (page!=null)
						currentPage = page;
				} catch (IndexOutOfBoundsException e) {
					this.renderer.renderMessage(Messages.INDEX_OUT_OF_BOUNDS.toString());
					continue;
				}
				break;
			}
		}
	}

	public void stop() {
		isRunning = false;
	}
}
