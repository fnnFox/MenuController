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
		this.itemList.set(0, Item.Backer(this,destination));
		return this;
	}
	public Page setEnder() {
		this.itemList.set(0, Item.Ender(this));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(title).append("\n");
		for (int i = 0; i < itemList.size(); i++) {
			output
					.append(i+1)
					.append(". ")
					.append(itemList.get(i).getLabel())
					.append("\n");
		}
		output.deleteCharAt(output.length()-1);
		return output.toString();
	}
}
