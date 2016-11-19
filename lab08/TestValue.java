package lab08;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lab08.Card.Suit;

public class TestValue {
	

	@Test
	public void test() {
		BlackjackHand test1 = new BlackjackHand();
		test1.addCard(new Card(Suit.Hearts,2));
		test1.addCard(new Card(Suit.Spades,4));
		assertEquals(6, test1.value());
	}
	@Test
	public void test2() {
		BlackjackHand test2 = new BlackjackHand();
		test2.addCard(new Card(Suit.Hearts,10));
		test2.addCard(new Card(Suit.Spades,11));
		assertEquals(21, test2.value());
	}
	@Test
	public void test3() {
		BlackjackHand test3 = new BlackjackHand();
		test3.addCard(new Card(Suit.Hearts,11));
		test3.addCard(new Card(Suit.Spades,11));
		assertEquals(12, test3.value());
	}
	@Test
	public void test4() {
		BlackjackHand test4 = new BlackjackHand();
		test4.addCard(new Card(Suit.Hearts,11));
		test4.addCard(new Card(Suit.Spades,11));
		test4.addCard(new Card(Suit.Clubs,11));
		assertEquals(13, test4.value());
	}
	@Test
	public void test5() {
		BlackjackHand test5 = new BlackjackHand();
		test5.addCard(new Card(Suit.Hearts,10));
		test5.addCard(new Card(Suit.Spades,10));
		test5.addCard(new Card(Suit.Clubs,2));
		assertEquals(22, test5.value());
	}
	@Test
	public void test6() {
		BlackjackHand test6 = new BlackjackHand();
		test6.addCard(new Card(Suit.Hearts,10));
		test6.addCard(new Card(Suit.Spades,10));
		test6.addCard(new Card(Suit.Clubs,11));
		assertEquals(21, test6.value());
	}
	@Test
	public void test7() {
		BlackjackHand test7 = new BlackjackHand();
		test7.addCard(new Card(Suit.Hearts,11));
		test7.addCard(new Card(Suit.Spades,11));
		test7.addCard(new Card(Suit.Clubs,11));
		test7.addCard(new Card(Suit.Diamonds,11));
		test7.addCard(new Card(Suit.Diamonds,6));
		assertEquals(20, test7.value());
	}

}
