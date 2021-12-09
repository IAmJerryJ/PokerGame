//Runde Jia 44434065

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

	/**
	 * Instantiate and populate ArrayList 'cards' such that
	 * it contains a card of every possible suit and rank.
	 * After being populated, the deck should contain 64 cards.
	 *  
	 */
	public Deck() {
		cards = new ArrayList<Card>();
		for(int suit = 0; suit < Card.validSuits.length; suit++) {
			String s = Card.validSuits[suit];				//give each suit to the card
			for(int rank = 5; rank < 21; rank++) {			// loop rank
				Card ACard = new Card(s , rank);			
				cards.add(ACard);
				}
		}
		//to be completed
	}

	/**
	 * @return a random card from the deck.
	 * IMPORTANT: This is like dealing a card from the deck,
	 * so it is important that the card you return gets
	 * removed from the deck.
	 */
	public Card getRandomCard() {
		 Random randomCard = new Random();						// call randomizer
	     int outCard = randomCard.nextInt(cards.size());		//limit random range
	     return cards.remove(outCard);							//remove random card from deck
		// to be completed
		//return null;
	}

	/**
	 * Shuffle the deck.
	 * 
	 * Hint: one way to do this is:
	 * - Pick two random cards in the deck.
	 * - Swap their locations in the deck.
	 * - Repeat this N times (where N is the number of cards in the deck.)
	 * - Now all the cards should be randomly placed.
	 */
	public void shuffle() {
		Random rand = new Random();							//randomizer
		for(int i = 0; i < cards.size(); i++) {
			int first = rand.nextInt(cards.size());			//find first random card
			int second = rand.nextInt(cards.size());		//find second random card
			Card temp = cards.get(first);					//swap first and second card
			cards.set(first, cards.get(second));
			cards.set(second, temp);
		}
		// to be completed
	}

	/**
	 * @return an ArrayList containing 'n' random cards.
	 * 
	 * The cards added to the ArrayList returned must be removed from the deck.
	 * 
	 * If there aren't enough cards in the deck to deal 'n' cards, return null.
	 * 
	 */
	public ArrayList<Card> deal(int n) {
		if(n <= cards.size()) {
		this.shuffle();									//shuffle the deck
		ArrayList<Card> newdeck2 = new ArrayList<Card>();			//create a new list to store random card
		for(int k = 0; k <  n; k++) {
			newdeck2.add(cards.get(k));					//add the chosen card to the new list
		}
		cards.removeAll(newdeck2);						//remove cards from the original deck
		return newdeck2;
		}
		//to be completed
		return null;							//if n is greater than the size of deck, return null
	}

	/**
	 * do not modify or delete
	 * @return the first card from the list
	 */
	public Card removeFirstCard() {
		if(cards.size() == 0)
			return null;
		return cards.remove(0);
	}

	/**
	 * do not modify or delete
	 * @return number of cards in the list
	 */
	public int size() {
		if (cards == null) return -1;
		return cards.size();
	}

	/**
	 * do not modify or delete
	 * add the parameter to the end of cards
	 */
	public void add(Card c) {
		cards.add(c);
	}

	/**
	 * do not modify or delete
	 * check if the deck contains a particular card
	 * @return true or false
	 */
	public boolean hasCard(String suit, int rank) {
		for (int i=0; i<cards.size(); i++)
			if (cards.get(i).getSuit().equals(suit) && cards.get(i).getRank() == rank)
				return true;
		return false;
	}
}
