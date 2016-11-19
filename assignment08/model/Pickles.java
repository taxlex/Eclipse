package assignment08.model;

public class Pickles extends BurgerDecorator {
	private static BurgerModel singleton = new Pickles();
	private Pickles () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
