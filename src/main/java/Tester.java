import Menu.ConsoleRenderer;
import Menu.MenuController;
import Menu.MenuCreator;
import Menu.MenuItem;

public class Tester {
	public static void main(String[] args) {
		MenuCreator creator = new MenuCreator();

		var page1 = creator.addPage("main").setTitle("Hello this is main page");
		var page2 = creator.addPage("second").setTitle("This is second page");

		page1
				.addItem(new MenuItem.Builder()
						.setLabel("Опция 1")
						.setLink(page2)
						.addAction((Object caller) -> {
							System.out.print("First Action is executing... ");
							System.out.println("Caller: "+((MenuItem)caller).getLabel());
						})
						.addAction((Object caller) -> {
							System.out.print("Second Action is executing... ");
							System.out.println("Caller: "+((MenuItem)caller).getLabel());
						})
						.build())
				.addItem(new MenuItem.Builder()
						.setName("label1")
						.setLabel("Опция два")
						.addAction((Object caller) -> {
							System.out.print("Action is executing... ");
							System.out.println("Caller: "+((MenuItem)caller).getLabel());
						})
						.build())
				.setEnder();
		page2
				.addItem(new MenuItem.Builder()
						.setName("label2")
						.setLabel("secccond")
						.build())
				.setBacker(page1);

		MenuController mc = new MenuController(creator, new ConsoleRenderer(), page1);

		mc.run();
	}
}
