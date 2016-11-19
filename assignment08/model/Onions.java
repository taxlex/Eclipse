package assignment08.model;

public class Onions extends BurgerDecorator {
	private static BurgerModel singleton = new Onions();
	private Onions () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
