package Menu;

public class Tester {
	public static void main(String[] args) {
		MenuCreator creator = new MenuCreator();
		creator.addPage("main")
				.setTitle("Првиет это основная страница")
				.addItem(new MenuItem.Builder()
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
		creator.addPage("second")
				.setTitle("это вторая страница")
				.addItem(new MenuItem.Builder()
						.setName("label1")
						.setLabel("Опция два")
						.addAction((Object caller) -> {
							System.out.print("Action is executing... ");
							System.out.println("Caller: "+((MenuItem)caller).getLabel());
						})
						.build());
		creator.getPage("second")
				.addItem(new MenuItem.Builder()
						.setName("label2")
						.setLabel("secccond")
						.build());

		MenuController mc = new MenuController(creator, "main");

		mc.run();
	}
}
