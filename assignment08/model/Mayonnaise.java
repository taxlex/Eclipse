package assignment08.model;

public class Mayonnaise extends BurgerDecorator {
	private static BurgerModel singleton = new Mayonnaise();
	private Mayonnaise () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
