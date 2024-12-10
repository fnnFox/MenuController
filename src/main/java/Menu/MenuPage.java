package Menu;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MenuPage extends MenuObject {
	private String title;
	private MenuItem zeroth;
	private final ArrayList<MenuItem> itemList = new ArrayList<>(10);

	public MenuPage(String name, MenuObject parent) {
		super(name,parent);
		this.itemList.add(null);
		this.setEnder();
	}

	public MenuPage addItem(MenuItem item) throws IllegalStateException {
		if (itemList.size()<9)
			itemList.add(item);
		else
			throw new IllegalStateException("Count of items in a page must be less than 10");
		return this;
	}
	public MenuItem getItem(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= itemList.size()) throw new IndexOutOfBoundsException();
		return itemList.get(index);
	}
	public ArrayList<MenuItem> getItemList() {
		return itemList;
	}
	public String getTitle() {
		return title;
	}

	public MenuPage setTitle(String title) {
		this.title = title;
		return this;
	}
	public MenuPage setBacker(MenuPage destination) {
		this.itemList.set(0, MenuItem.Backer(this,destination));
		return this;
	}
	public MenuPage setEnder() {
		this.itemList.set(0, MenuItem.Ender(this));
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
