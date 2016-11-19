package assignment08.view;

import java.util.Map;
import java.util.TreeMap;

import assignment08.model.Bacon;
import assignment08.model.BurgerDecorator;
import assignment08.model.BurgerModel;
import assignment08.model.Cheese;
import assignment08.model.ConcreteBurgerModel;
import assignment08.model.Ketchup;
import assignment08.model.Lettuce;
import assignment08.model.Mayonnaise;
import assignment08.model.Mustard;
import assignment08.model.Onions;
import assignment08.model.Pickles;
import assignment08.model.Tomato;
import assignment08.model.ToppingDetails;


public class ToppingsManager {
	// the "burger" variable will always point at the first 
	// decorator:
	private static BurgerModel burger = ConcreteBurgerModel.getHandle();
	public static Map<String,ToppingDetails> toppingsMap = new TreeMap<String,ToppingDetails>(); // sort alphabetically on keys
	public static Map<String,BurgerModel> toppingsObjects = new TreeMap<String,BurgerModel>(); // sort alphabetically on keys

	static {
		toppingsMap.put("bacon", new ToppingDetails("bacon",15,5)); 
		toppingsMap.put("mustard", new ToppingDetails("mustard",10,5)); 
		toppingsMap.put("lettuce", new ToppingDetails("lettuce", 4, 0)); 
		toppingsMap.put("tomato", new ToppingDetails("tomato", 5, 0)); 
		toppingsMap.put("ketchup", new ToppingDetails("ketchup", 5, 0)); 
		toppingsMap.put("pickles", new ToppingDetails("pickles", 5, 0)); 
		toppingsMap.put("onions", new ToppingDetails("onions", 5, 0)); 
		toppingsMap.put("mayonnaise", new ToppingDetails("mayonnaise", 5, 0)); 
		toppingsMap.put("cheese", new ToppingDetails("cheese", 5, 0)); 

		toppingsObjects.put("bacon", Bacon.getHandle()); 
		toppingsObjects.put("mustard", Mustard.getHandle()); 
		toppingsObjects.put("lettuce", Lettuce.getHandle()); 
		toppingsObjects.put("tomato", Tomato.getHandle()); 
		toppingsObjects.put("ketchup", Ketchup.getHandle()); 
		toppingsObjects.put("pickles", Pickles.getHandle()); 
		toppingsObjects.put("onions", Onions.getHandle()); 
		toppingsObjects.put("mayonnaise", Mayonnaise.getHandle()); 
		toppingsObjects.put("cheese", Cheese.getHandle()); 
	}

	public static void addTopping(ToppingDetails detail) {
		// TODO
		// get the topping object for the parameter detail, 
		// BurgerDecorator topping = ((BurgerDecorator)toppingsObject.get(detail.getName())
		// using detail.getName() and the toppingsObject Map above,
		BurgerDecorator topping = ((BurgerDecorator)toppingsObjects.get(detail.getName()));
		burger = topping.addTopping(burger);
		// then use:
            // BurgerDecorator topping = (BurgerDecorator)toppingsObject.get(detail.getName());
		// burger = topping.addTopping(burger); 
		// which uses the addTopping from BurgerDecorator
	}
	public static void removeTopping(ToppingDetails detail) {
		// TODO
		// get the topping object for the parameter detail, 
		// using detail.getName() and the toppingsObject Map above,
		// then use removeTopping from BurgerDecorator
		// using
		// burger = ((BurgerDecorator)burger).removeTopping(topping);
		BurgerDecorator topping = ((BurgerDecorator)toppingsObjects.get(detail.getName()));
		burger = ((BurgerDecorator)burger).removeTopping(topping);
	}
	public static int getTotalCalories() {
		return burger.getTotalCalories();
	}
	public static Double getTotalPrice() {
		return burger.getTotalCost();
	}
	public static BurgerModel getBurger() {
		return burger;		
	}
}
