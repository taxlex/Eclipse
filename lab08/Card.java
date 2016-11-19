package lab08;

public class Card {
	public static enum Suit { Hearts, Diamonds, Clubs, Spades };
	private Suit suit;
	private int value;
	public Card(Suit asuit, int avalue){
		if(avalue < 2 || avalue>11) throw new IllegalArgumentException("value must be between 2 and 11");
		suit = asuit;
		value = avalue;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public boolean equals(Object other){
		boolean yesno;
		if(other instanceof Card == false ) yesno = false;
		else{
			Card temp = (Card)other;
			if(temp.getSuit() == suit && temp.getValue() == value) yesno = true;
			else yesno = false;
		}
		return yesno;
		
	}
	@Override
	public int hashCode(){
		return 31 * suit.hashCode() + 7 * Integer.hashCode(value);
	}
	@Override
	public String toString(){
		String temp = "";
		if(value == 11) temp = temp + "Ace";
		else temp = temp + value;
		temp = temp + " of " + suit.toString();
		return temp;
	}
	public static void main(String[] args){
		Card c1 = new Card(Suit.Spades, 11);
		Card c2 = new Card(Suit.Spades, 11);
		Card c3 = new Card(Suit.Clubs, 11);
		Card c4 = new Card(Suit.Spades, 10);
		System.out.println(c1.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c4));
		System.out.println(c1.hashCode());
	}
}
