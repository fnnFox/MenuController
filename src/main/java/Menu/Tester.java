package Menu;

public class Tester {
	public static void main(String[] args) {
		MenuCreator creator = new MenuCreator();
		creator.addPage("main", "Првиет это основная страница");
		creator.addPage("second", "это вторая страница");
		creator.selectPage("main");
		creator.addItemsToSelectedPage(new MenuItem.Builder()
				.setLabel("Опция 1")
				.setLink("second")
				.addAction((Object caller) -> {
					System.out.print("First Action is executing... ");
					System.out.println("Caller: "+((MenuItem)caller).getLabel());
				})
				.addAction((Object caller) -> {
					System.out.print("Second Action is executing... ");
					System.out.println("Caller: "+((MenuItem)caller).getLabel());
				})
				.build());
		creator.addItemsToSelectedPage(new MenuItem.Builder()
				.setLabel("Опция два")
				.addAction((Object caller) -> {
					System.out.print("Action is executing... ");
					System.out.println("Caller: "+((MenuItem)caller).getLabel());
				})
				.build());
		creator.selectPage("second");
		creator.addItemsToSelectedPage(new MenuItem.Builder()
				.setLabel("secccond")
				.build());

		MenuController mc = new MenuController(creator, "main");

		mc.run();
	}
}
