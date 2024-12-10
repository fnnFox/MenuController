package Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem extends MenuObject {
	private static String backerLabel = "Back";
	private static String enderLabel = "Exit";
	private String label;
	private final List<Action> actions;
	private MenuPage link;

	public MenuItem(Builder builder) {
		super(builder.name,builder.parent);
		this.label = builder.label;
		this.link = builder.link;
		this.actions = builder.actions;
	}
	public MenuItem(String name, MenuObject parent, MenuPage link, String label) {
		super(name,parent);
		this.label = label;
		this.link = link;
		this.actions = new ArrayList<>();
	}

	public MenuItem setLabel(String label) {
		this.label = label;
		return this;
	}
	public String getLabel() {
		return label;
	}

	public MenuItem addAction(Action action) {
		this.actions.add(action);
		return this;
	}
	public MenuItem removeAction(Action action) {
		actions.remove(action);
		return this;
	}
	public MenuItem addActions(List<Action> actions) {
		this.actions.addAll(actions);
		return this;
	}
	public List<Action> getActions() {
		return actions;
	}

	public MenuItem setLink(MenuPage link) {
		this.link = link;
		return this;
	}
	public MenuPage getLink() {
		return link;
	}

	public MenuPage runActions() {
		for (var action : actions)
			action.execute(this);
		return link;
	}

	public static MenuItem Ender(MenuPage parent) {
		return new MenuItem(parent.getName()+"_ender", parent, null, enderLabel)
				.addAction(x -> ((MenuCreator)parent.getParent()).getController().stop());
	}
	public static String getEnderLabel() {
		return enderLabel;
	}
	public static void setEnderLabel(String enderLabel) {
		MenuItem.enderLabel = enderLabel;
	}

	public static MenuItem Backer(MenuPage from, MenuPage to) {
		return new MenuItem(from.getName()+"_backer", from, to, backerLabel);
	}
	public static String getBackerLabel() {
		return backerLabel;
	}
	public static void setBackerLabel(String label) {
		backerLabel = label;
	}


	public static class Builder {

		private String name;
		private String label;
		private final List<Action> actions = new ArrayList<>();
		private MenuPage link;
		private MenuPage parent;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}
		public Builder addAction(Action action) {
			this.actions.add(action);
			return this;
		}
		public Builder setLink(MenuPage link) {
			this.link = link;
			return this;
		}
		public Builder setParent(MenuPage parent) {
			this.parent = parent;
			return this;
		}

		public MenuItem build() {
			return new MenuItem(this);
		}
	}
}
