package Menu;

import java.util.List;
import java.util.Scanner;

public class ConsoleRenderer implements MenuRenderer {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void renderTitle(String title) {
		System.out.println(title);
	}

	@Override
	public void renderItems(List<MenuItem> items) {
		for (int i = 1; i < items.size(); i++) {
			System.out.println(i + ". " + items.get(i).getLabel());
		}
		System.out.println(0 + ". " + items.get(0).getLabel());
	}

	@Override
	public int getUserChoice() {
		int input;
		while (true) {
			try {
				input = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(Messages.INCORRECT_INPUT);
				continue;
			}
			break;
		}
		return input;
	}

	@Override
	public void renderMessage(String message) {
		System.out.println(message);
	}
}
