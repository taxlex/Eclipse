package assignment08.languageStrategy;

import java.util.Map;
import java.util.TreeMap;

import assignment08.model.ToppingDetails;
import assignment08.view.DynamicScreenManager;

public abstract class LanguageStrategy {
	protected Map<String,String> spanishDictionary = new TreeMap<String,String>();
	protected Map<String,String> englishDictionary = new TreeMap<String,String>();
	protected Map<String,String> germanDictionary = new TreeMap<String,String>();
	protected Map<String,String> chineseDictionary = new TreeMap<String,String>();
	public LanguageStrategy () {
		populateEnglishDictionary();
		populateSpanishDictionary();
		populateGermanDictionary();
		populateChineseDictionary();
	}
	private void populateEnglishDictionary() {
		englishDictionary.put("mustard","mustard");
		englishDictionary.put("lettuce","lettuce");
		englishDictionary.put("tomato","tomato");
		englishDictionary.put("bacon","bacon");
		englishDictionary.put("ketchup", "ketchup");  
		englishDictionary.put("pickles", "pickles"); 
		englishDictionary.put("onions", "onions");  
		englishDictionary.put("mayonnaise", "mayonnaise"); 
		englishDictionary.put("caloriestitle", "CALORIES"); 
		englishDictionary.put("pricetitle", "PRICE"); 
		englishDictionary.put("topping", "TOPPING"); 
		englishDictionary.put("caloriestotal", "calories: "); 
		englishDictionary.put("pricetotal", "price: "); 
		englishDictionary.put("cheese", "cheese"); 
	}
	private void populateSpanishDictionary() {
		spanishDictionary.put("mustard","mostaza");
		spanishDictionary.put("lettuce","lechuga");
		spanishDictionary.put("tomato","tomate");
		spanishDictionary.put("bacon","tocino");
		spanishDictionary.put("ketchup", "ketchup");  
		spanishDictionary.put("pickles", "encurtidos"); 
		spanishDictionary.put("onions", "cebolla");  
		spanishDictionary.put("mayonnaise", "mayonesa");  
		spanishDictionary.put("caloriestitle", "CALORIAS"); 
		spanishDictionary.put("pricetitle", "PRECIO"); 
		spanishDictionary.put("topping", "CON ..."); 
		spanishDictionary.put("caloriestotal", "calorias"); 
		spanishDictionary.put("pricetotal", "precio"); 
		spanishDictionary.put("cheese", "queso"); 
	}
	private void populateGermanDictionary() {
		germanDictionary.put("mustard","Senf");
		germanDictionary.put("lettuce","Kopfsalat");
		germanDictionary.put("tomato","Tomate");
		germanDictionary.put("bacon","Speck");
		germanDictionary.put("ketchup", "Ketchup");  
		germanDictionary.put("pickles", "Pickles"); 
		germanDictionary.put("onions", "Zwiebeln");  
		germanDictionary.put("mayonnaise", "Mayonnaise");  
		germanDictionary.put("caloriestitle", "KALORIEN"); 
		germanDictionary.put("pricetitle", "PREIS"); 
		germanDictionary.put("topping", "TOPPING"); 
		germanDictionary.put("caloriestotal", "Kalorien"); 
		germanDictionary.put("pricetotal", "Preis"); 
		germanDictionary.put("cheese", "K" + (char)228 + "se"); 
	}
	private void populateChineseDictionary() {
		//using http://weber.ucsd.edu/~dkjordan/resources/unicodemaker.html
		//http://translate.google.com/?tl=zh#auto/zh-CN/
		chineseDictionary.put("mustard","\u82a5\u672b");
		chineseDictionary.put("lettuce","\u751f\u83dc");
		chineseDictionary.put("tomato","\u5976\u916a");
		chineseDictionary.put("bacon", "bacon"); // needs work
		chineseDictionary.put("ketchup", "ketchup"); // needs work  
		chineseDictionary.put("pickles", "pickles"); // needs work
		chineseDictionary.put("onions", "onions");  // needs work
		chineseDictionary.put("mayonnaise", "mayonnaise"); // needs work
		chineseDictionary.put("caloriestitle", "\u5361\u8def\u91cc"); 
		chineseDictionary.put("pricetitle", "PRICE"); // needs work
		chineseDictionary.put("topping", "\u718f\u8089"); // needs work
		chineseDictionary.put("caloriestotal", "\u5361\u8def\u91cc: "); 
		chineseDictionary.put("pricetotal", "price: "); // needs work
		chineseDictionary.put("cheese", "cheese"); // needs work
	}
	public abstract void changeLanguage(Map<String,ToppingDetails> map);
	public abstract void changeTitles(DynamicScreenManager dsm);
	public abstract void changeTotals(DynamicScreenManager dsm);
}
