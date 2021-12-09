

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DeckTest {

	
	@Test
	public void testDeck() {
		Deck d = new Deck();
		
		// check there are 64 cards
		assertEquals(64, d.size());
		
		// check that every card is present in the deck
		for (String s: new String[]{"tree", "stone", "lung", "fork"}) {
			for (int r=20; r>=5; r--) {
				assertTrue(d.hasCard(s, r));
			}
		}
	}

	@Test
	public void testGetRandomCard() {
		// test the getRandomCard method
		// note: you need your default constructor working
		// before this test can pass
		Deck d = new Deck();
		
		int cardsInDeck = d.size(); 
		
		// manually get 16 random cards
		ArrayList<Card> hand = new ArrayList<Card>();
		for(int i=0; i < 16; i++) {
			hand.add(d.getRandomCard());
		}
		
		// check that 16 cards are now missing
		assertEquals(cardsInDeck-16, d.size());
		
		// check there are no repeats
		boolean duplicates = false;
		for(int i=0; i < hand.size(); i++) {
			for(int k=i+1; k < hand.size(); k++) {
				if(hand.get(i).getSuit().equals(hand.get(k).getSuit()))
					if (hand.get(i).getRank() == hand.get(k).getRank())
						duplicates = true;
			}
		}
		assertFalse(duplicates);
	}

	
	@Test
	public void testShuffle() {
		Deck d1 = new Deck();
		Deck d2 = new Deck();
		
		// check shuffling doesn't change deck size
		int sizebefore = d1.size();
		d1.shuffle();
		assertEquals(sizebefore, d1.size());
		
		// deal the whole decks into hands.
		ArrayList<Card> hand1 = new ArrayList<Card>();
		ArrayList<Card> hand2 = new ArrayList<Card>();
		for (int i=0; i<d1.size(); i++) {
			hand1.add(d1.removeFirstCard());
			hand2.add(d2.removeFirstCard());
		}
		
		// check the two hands don't have much in common
		int countsame = 0;
		for (int i=0; i<hand1.size(); i++) {
			if (hand1.get(i).getSuit().equals(hand2.get(i).getSuit()))
				if (hand1.get(i).getRank() == hand2.get(i).getRank())
					countsame++;
		}
		assertTrue(countsame < 10);
	}


	@Test
	public void testDeal() {
		Deck d = new Deck();
		int decksize = d.size();
		
		// deal two hands, check the cards have left the deck
		ArrayList<Card> hand1 = d.deal(16);
		assertEquals(decksize-16, d.size());
		
		ArrayList<Card> hand2 = d.deal(16);
		assertEquals(decksize-32, d.size());
		
		// check they are the right sizes
		assertEquals(16, hand1.size());
		assertEquals(16, hand2.size());
		
		// check the hands have no cards in common
		int countsame = 0;
		for (int i=0; i<16; i++) {
			for (int k=0; k<16; k++) {
				if (hand1.get(i).getSuit().equals(hand2.get(k).getSuit()))
					if (hand1.get(i).getRank() == hand2.get(k).getRank())
						countsame++;
			}
		}
		assertEquals(0, countsame);
	}

}
