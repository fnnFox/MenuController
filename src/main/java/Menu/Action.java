package Menu;

public interface Action {
	/**
	 * Interface representing an action that can be executed.
	 * Implementing classes should define the specific behavior of the action.
	 *
	 * @param caller The object that triggered the action (e.g., a menu item).
	 */
	void execute(Object caller);
}