package assignment08.model;

import assignment08.model.BurgerDecorator;
import assignment08.model.BurgerModel;
import assignment08.view.ToppingsManager;

public abstract class BurgerDecorator extends BurgerModel {
	protected BurgerModel next;
	protected int calories;
	protected Double price;
	public BurgerModel addTopping(BurgerModel burger) {
		// assign "this.next" so that it references burger
		this.next = burger;
		return this;  
	}
	public BurgerModel removeTopping (BurgerDecorator topping) {
		BurgerModel retVal = this;
		// if "this" is the topping to be removed, assign retVal to next
		// (since the toppings are Singleton objects you can
		// use == to test for equality of objects in this case,
		// i.e. if(this == topping)
		// otherwise next = ((BurgerDecorator)next).removeTopping (topping)
		if(this == topping) retVal = next;
		else next = ((BurgerDecorator)next).removeTopping (topping);
		return retVal;
	}
	
	public int getTotalCalories() {
		String str = getClass().getSimpleName().toLowerCase();
		return ToppingsManager.toppingsMap.get(str).getCalories() 
				+ next.getTotalCalories();
	}

	public Double getTotalCost() {
		String str = getClass().getSimpleName().toLowerCase();
		return ToppingsManager.toppingsMap.get(str).getCost() + next.getTotalCost();
		//return  0.0;
		// this should be similar to getTotalCalories
		// return new Double(0); //remove this line after completing the line above
	}


}
