package Menu;

import Abstract.MenuObject;

import java.util.ArrayList;

public class Page extends MenuObject {
	private String title;
	private final ArrayList<Item> itemList = new ArrayList<>(10);

	public Page(String name, MenuObject parent) {
		super(name,parent);
		this.itemList.add(null);
		this.setEnder();
	}

	public Page addItem(Item item) throws IllegalStateException {
		if (itemList.size()<9)
			itemList.add(item);
		else
			throw new IllegalStateException("Count of items in a page must be less than 10");
		return this;
	}
	public Item getItem(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= itemList.size()) throw new IndexOutOfBoundsException();
		return itemList.get(index);
	}
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public String getTitle() {
		return title;
	}

	public Page setTitle(String title) {
		this.title = title;
		return this;
	}
	public Page setBacker(Page destination) {
		this.itemList.set(0, new Item(this.getName()+"_backer", this, destination, Item.getBackerLabel()));
		return this;
	}
	public Page setEnder() {
		this.itemList.set(0, new Item(this.getName()+"_ender", this, null, Item.getEnderLabel())
				.addAction(x -> ((Controller)this.getContainer()).stop()));
		return this;
	}
}
