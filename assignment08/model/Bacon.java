package assignment08.model;

public class Bacon extends BurgerDecorator{
	private static BurgerModel singleton = new Bacon();
	private Bacon () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
}
