package Menu;

import Abstract.MenuObject;
import Interfaces.MenuRenderer;
import Messages.Messages;

public class Controller extends MenuObject {
	private static int counter = 1;
	private Page currentPage;
	private final MenuRenderer renderer;

	private boolean isRunning;

	public Controller(MenuRenderer renderer, Page startPage) {
		super("controller"+counter++,null);
		this.renderer = renderer;
		this.currentPage = startPage;
	}

	public Page addPage(String name) {
		return new Page(name,this);
	}

	public void setStartPage(Page startPage) {
		if (startPage == null) {
			throw new IllegalArgumentException("Start page cannot be null");
		}
		this.currentPage = startPage;
	}

	public void run() {
		if (renderer==null) throw new IllegalStateException("Renderer must be set");
		if (currentPage==null) throw new IllegalStateException("Start page must be not null");

		isRunning = true;
		while (isRunning) {
			this.renderer.renderTitle(currentPage.getTitle());
			this.renderer.renderItems(currentPage.getItemList());

			while (true) {
				int index = this.renderer.getUserChoice();
				try {
					Page page = this.currentPage.getItem(index).runActions();
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

	public static class Builder {
		private MenuRenderer renderer = null;
		private Page startPage = null;

		public Builder setRenderer(MenuRenderer renderer) {
			this.renderer = renderer;
			return this;
		}
		public void setStartPage(Page startPage) {
			if (startPage == null) {
				throw new IllegalArgumentException("Start page cannot be null");
			}
			this.startPage = startPage;
		}
		public Controller build() {
			if (renderer == null) {
				throw new IllegalStateException("Renderer must be set");
			}
			return new Controller(renderer, startPage);
		}
	}

}
