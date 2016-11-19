package assignment08.model;

public class Mustard extends BurgerDecorator {
	private static BurgerModel singleton = new Mustard();
	private Mustard () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
