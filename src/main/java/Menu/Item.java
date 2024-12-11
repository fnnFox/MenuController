package Menu;

import Abstract.MenuObject;
import Interfaces.Action;

import java.util.ArrayList;
import java.util.List;

public class Item extends MenuObject {
	private static String backerLabel = "Back";
	private static String enderLabel = "Exit";
	private String label;
	private final List<Action> actions;
	private Page link;

	public Item(Builder builder) {
		super(builder.name,builder.parent);
		this.label = builder.label;
		this.link = builder.link;
		this.actions = builder.actions;
	}
	public Item(String name, MenuObject parent, Page link, String label) {
		super(name,parent);
		this.label = label;
		this.link = link;
		this.actions = new ArrayList<>();
	}

	public Item setLabel(String label) {
		this.label = label;
		return this;
	}
	public String getLabel() {
		return label;
	}

	public Item addAction(Action action) {
		this.actions.add(action);
		return this;
	}
	public Item removeAction(Action action) {
		actions.remove(action);
		return this;
	}
	public Item addActions(List<Action> actions) {
		this.actions.addAll(actions);
		return this;
	}
	public List<Action> getActions() {
		return actions;
	}

	public Item setLink(Page link) {
		this.link = link;
		return this;
	}
	public Page getLink() {
		return link;
	}

	public Page runActions() {
		for (var action : actions)
			action.execute(this);
		return link;
	}

	public static String getEnderLabel() {
		return enderLabel;
	}
	public static void setEnderLabel(String enderLabel) {
		Item.enderLabel = enderLabel;
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
		private Page link;
		private Page parent;

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
		public Builder setLink(Page link) {
			this.link = link;
			return this;
		}
		public Builder setParent(Page parent) {
			this.parent = parent;
			return this;
		}

		public Item build() {
			return new Item(this);
		}
	}
}
