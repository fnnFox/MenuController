package Menu;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class MenuController {
	private final Scanner scanner = new Scanner(System.in);
	private final Stack<MenuPage> menuPageStack = new Stack<>();
	private final HashMap<String, MenuPage> menuPageMap;

	private boolean isRunning;

	public MenuController(MenuCreator creator, String startPage) {
		this.menuPageMap = creator.getPageMap();
		this.menuPageStack.push(this.menuPageMap.get(startPage));
	}

	public void run() {
		isRunning = true;
		while (isRunning) {

			System.out.println(menuPageStack.peek());
			System.out.println("0. "+Messages.GET_BACK);

			boolean correctCheck = true;
			while (correctCheck) {
				int input;
				try {
					input = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println(Messages.INCORRECT_INPUT);
					continue;
				}
				if (input > 9 || input < 0) {
					System.out.println(Messages.INCORRECT_INPUT);
					continue;
				}
				if (input == 0) {
					menuPageStack.pop();
					isRunning = !(menuPageStack.isEmpty());
					break;
				} else {
					try {
						String link = menuPageStack.peek().getItem(input - 1).run();
						if (link != null) {
							menuPageStack.push(menuPageMap.get(link));
						}
						correctCheck = false;
					} catch (IndexOutOfBoundsException e) {
						System.out.println(Messages.INDEX_OUT_OF_BOUNDS);
						continue;
					}
				}
			}
		}
	}
}
