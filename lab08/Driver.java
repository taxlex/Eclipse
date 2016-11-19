package lab08;

import lab08.Card.Suit;

public class Driver {
	public static void main(String[] args){
		BlackjackHand test = new BlackjackHand();
		test.addCard(new Card(Suit.Hearts,11));
		test.addCard(new Card(Suit.Spades,11));
		test.addCard(new Card(Suit.Clubs,11));
		test.addCard(new Card(Suit.Diamonds,11));
		test.addCard(new Card(Suit.Diamonds,6));
		System.out.println(test.value());
		
		BlackjackMethod test2a = new BlackjackMethod();
		ComposedHand test2 = new ComposedHand(test2a);
		test2.addCard(new Card(Suit.Hearts,11));
		test2.addCard(new Card(Suit.Spades,11));
		test2.addCard(new Card(Suit.Clubs,11));
		test2.addCard(new Card(Suit.Diamonds,11));
		test2.addCard(new Card(Suit.Diamonds,6));
		System.out.println(test2.value());
	}
}
