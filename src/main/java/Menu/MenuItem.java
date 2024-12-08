package Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
	private String label;
	private final List<Action> actions;
	private String link;

	public MenuItem(Builder builder) {
		this.label = builder.label;
		this.actions = builder.actions;
		this.link = builder.link;
	}
	public String run() {
		for (var action : actions)
			action.execute(this);
		return link;
	}
	public String getLabel() {
		return label;
	}
	public List<Action> getActions() {
		return actions;
	}
	public boolean removeAction(Action action) {
		return actions.remove(action);
	}
	public String getLink() {
		return link;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean addAction(Action action) {
		return this.actions.add(action);
	}
	public void setLink(String link) {
		this.link = link;
	}

	public static class Builder {

		private String label;
		private final List<Action> actions = new ArrayList<>();
		private String link;

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder addAction(Action action) {
			this.actions.add(action);
			return this;
		}

		public Builder setLink(String link) {
			this.link = link;
			return this;
		}

		public MenuItem build() {
			return new MenuItem(this);
		}
	}
}
