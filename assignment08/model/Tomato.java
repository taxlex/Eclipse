package assignment08.model;

public class Tomato extends BurgerDecorator{
	private static BurgerModel singleton = new Tomato();
	private Tomato () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
