package assignment08.model;

public class Lettuce extends BurgerDecorator {
	private static BurgerModel singleton = new Lettuce();
	private Lettuce () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	String str = getClass().getSimpleName().toLowerCase();
	
}
