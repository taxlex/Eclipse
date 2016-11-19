package assignment08.model;

public class Ketchup extends BurgerDecorator {
	private static BurgerModel singleton = new Ketchup();
	private Ketchup () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
