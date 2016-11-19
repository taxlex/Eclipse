package lab08;

import java.util.ArrayList;
import java.util.List;

public class ComposedHand {
	List<Card> cards = new ArrayList<>();
	private ComputationMethod method;
	public ComposedHand(ComputationMethod amethod){
		method = amethod;
	}
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
	public int value(){
		return method.compute(cards);
	}
}
