import Interfaces.MenuRenderer;
import Renderer.ConsoleRenderer;
import Menu.Controller;
import Menu.Item;

public class Tester {
	public static void main(String[] args) {
		MenuRenderer renderer = new ConsoleRenderer();
		Controller controller = new Controller.Builder().setRenderer(renderer).build();

		var page1 = controller.addPage("main").setTitle("Hello this is main page");
		var page2 = controller.addPage("second").setTitle("This is second page");

		controller.setStartPage(page1);

		page1
				.addItem(new Item.Builder()
						.setLabel("Опция 1")
						.setLink(page2)
						.addAction((Object caller) -> {
							System.out.print("First Action is executing... ");
							System.out.println("Caller: "+((Item)caller).getLabel());
						})
						.addAction((Object caller) -> {
							System.out.print("Second Action is executing... ");
							System.out.println("Caller: "+((Item)caller).getLabel());
						})
						.build())
				.addItem(new Item.Builder()
						.setName("label1")
						.setLabel("Опция два")
						.addAction((Object caller) -> {
							System.out.print("Action is executing... ");
							System.out.println("Caller: "+((Item)caller).getLabel());
						})
						.build())
				.setEnder();
		page2
				.addItem(new Item.Builder()
						.setName("label2")
						.setLabel("secccond")
						.build())
				.setBacker(page1);

		controller.run();
	}
}
