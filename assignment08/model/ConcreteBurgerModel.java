package assignment08.model;
public class ConcreteBurgerModel extends BurgerModel {
	private static BurgerModel singleton = new ConcreteBurgerModel();
	private static Double PRICE = new Double (200.0);
	private ConcreteBurgerModel() {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	public int getTotalCalories() {
		return 200; //you can correct this if you care to
	}
	public Double getTotalCost() {		
		return PRICE;
	}		
}
