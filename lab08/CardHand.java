package lab08;

import java.util.ArrayList;
import java.util.List;

public abstract class CardHand {
	List<Card> cards = new ArrayList<>();
	public void addCard(Card c){
		cards.add(c);
	}
	public void clear(){
		cards.clear();
	}
	@Override
	public String toString(){
		return cards.toString();
	}
	public abstract int value();
	
}
