package assignment08.languageStrategy;
import java.util.Map;

import assignment08.model.ToppingDetails;
import assignment08.view.DynamicScreenManager;

public class LanguageChinese extends LanguageStrategy {
	public void changeLanguage(Map<String, ToppingDetails> map) {
		for(ToppingDetails t : map.values()) {
			t.setMoneyUnit("cents");
			t.setFreeWord("free");
			t.setScreenName((String)chineseDictionary.get(t.getName()));
			t.update();			
		}
	}
	public void changeTitles(DynamicScreenManager dsm) {
		dsm.getCaloriesTitle1().setText((String)chineseDictionary.get("caloriestitle"));
		dsm.getToppingsTitle1().setText((String)chineseDictionary.get("topping"));
		dsm.getPriceTitle1().setText((String)chineseDictionary.get("pricetitle"));
		dsm.getCaloriesTitle2().setText((String)chineseDictionary.get("caloriestitle"));
		dsm.getToppingsTitle2().setText((String)chineseDictionary.get("topping"));
		dsm.getPriceTitle2().setText((String)chineseDictionary.get("pricetitle"));
	}
	public void changeTotals(DynamicScreenManager dsm) {
		dsm.getCaloriesTotal().setText((String)chineseDictionary.get("caloriestotal"));
		dsm.getPriceTotal().setText((String)chineseDictionary.get("pricetotal"));
	}
}
