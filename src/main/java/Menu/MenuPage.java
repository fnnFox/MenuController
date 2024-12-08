package Menu;

import java.util.ArrayList;

public class MenuPage {
	private String title;
	private ArrayList<MenuItem> itemList = new ArrayList<>();

	public MenuPage(String title) {
		this.title = title;
	}
	public void addItem(MenuItem item) throws IllegalStateException {
		if (itemList.size()<9)
			itemList.add(item);
		else
			throw new IllegalStateException("Count of items in a page must be less than 10. Create another page for more items.");
	}
	public MenuItem getItem(int index) throws IndexOutOfBoundsException {
		if (index < -1 || index >= itemList.size()) throw new IndexOutOfBoundsException();
		return itemList.get(index);
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
