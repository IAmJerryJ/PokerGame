//Runde Jia 44434065
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		int p1_score = 0;						//set player 1 and player 2's scores
		int p2_score = 0;
		int round = 1;							//count the round
		Deck deck = new Deck();					//create the deck
		deck.shuffle();							//shuffle the deck
		ArrayList<Card> player1 = new ArrayList<Card>();			//player1's cards
		ArrayList<Card> player2 = new ArrayList<Card>();			//player2's cards
		while(deck.size() >= 12) {									//only start a round when there's at least a card left
			System.out.println("round " + round );
			int round_result = round(deck,player1, player2);			//start the round, and store the result of each round
		if(round_result == 1) {
			System.out.println("Clash");								//if player 1 won the round
			System.out.println("Player 1 gets a point");
			System.out.println("Out of cards. Dealing new hands");
			p1_score ++;
		}
		else if(round_result == -1) {									//if player 2 won the a round
			System.out.println("Clash");
			System.out.println("Player 2 gets a point");
			System.out.println("Out of cards. Dealing new hands");
			p2_score ++;
		}
		else {
			System.out.println("Out of cards. Dealing new hands");			//tie for the current round
		}
		deck.shuffle();												//shuffle the deck when start a new round
		round ++;													//get into next round
		}
		if(deck.size() < 12) {										//if there's no card left
			System.out.println("Game over!");
			System.out.println("Player 1: " + p1_score);			//display score for each player
			System.out.println("Player 2: " + p2_score);
			if(p1_score > p2_score)
				System.out.println("Player 1 won!");			//determine which player won
			else if(p1_score < p2_score)
				System.out.println("Player 2 won!");
			else
				System.out.println("It's a tie!");
		}
	}
	public static int round(Deck deck,ArrayList<Card> p1, ArrayList<Card> p2) {   //round method
		for(int i = 0; i < 6; i++) {			//when there's at least 12 cards left, give each player 6 cards
			p1.add(deck.getRandomCard());
			p2.add(deck.getRandomCard());
		}		
		System.out.println("Player 1: " + p1);
		System.out.println("Player 2: " + p2);
		for(int k = 0; k < p1.size(); k ++) {
			Card lastp2 = new Card();			
			if(k > 0) {
				lastp2 = p2.get(k - 1);}	//store last player2's card
			String string1 = "Player 1 plays "+ p1.get(k).toString();
			String string2 = "Player 2 plays "+ p2.get(k).toString();
			if(p1.get(k).getRank() != lastp2.getRank()) {   //if ranks of current player1 and last player2 are different, print out both current p1 and p2
			System.out.println(string1);
			System.out.println(string2);}
			else if(p1.get(k).getRank() == lastp2.getRank())		//if ranks of current p1 and p2 are same, only display current p1
				System.out.println(string1);
			if(p1.get(k).getRank() == p2.get(k).getRank() || p1.get(k).getRank() == lastp2.getRank()) { // if a player places a card the same rank as the most-recently-placed card
				if(p1.get(k).getRank() == p2.get(k).getRank())  //return cards in pot to deck
						for(int i = 0; i < k; i ++) {
							deck.add(p1.get(i));
							deck.add(p2.get(i));
						}
				else if(p1.get(k).getRank() == lastp2.getRank()) {		//if p1 == last p2's card, only return player1's kth card to the deck
					for(int i = 0; i < (k -1); i++) {
						deck.add(p1.get(i));
						deck.add(p2.get(i));
					}
					deck.add(p1.get(k));
				}
				if(p1.get(k).getSuitWeight() > p2.get(k).getSuitWeight() || p1.get(k).getSuitWeight() > lastp2.getSuitWeight()) { //if p1 is greater
					p1.removeAll(p1);
					p2.removeAll(p2);               //discard all cards left in both players' hand
					return 1;						//player 1 is the winner of this round
				}
				else if(p1.get(k).getSuitWeight() < p2.get(k).getSuitWeight() || p1.get(k).getSuitWeight() < lastp2.getSuitWeight()) {  //if p2 is greater
					p1.removeAll(p1);
					p2.removeAll(p2);			//discard
					return -1;					//player2 is the winner of this round
				}
			}
		}
		p1.removeAll(p1);      //if the round is tie, remove all cards in both players' hand
		p2.removeAll(p2);
		return 0;				//neither player gets a point
	}
		//simulation of a two-player game.
		//to be completed
		
	}

