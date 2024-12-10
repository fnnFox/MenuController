package Menu;

import java.util.List;

public interface MenuRenderer {
	/**
	 * Renders the page title.
	 * @param title The title of the page.
	 */
	void renderTitle(String title);

	/**
	 * Renders the menu items.
	 * @param items The list of menu items.
	 */
	void renderItems(List<MenuItem> items);

	/**
	 * Requests the user's choice.
	 * @return The index chosen by the user.
	 */
	int getUserChoice();

	/**
	 * Displays a message to the user.
	 * @param message The message to display.
	 */
	void renderMessage(String message);
}
