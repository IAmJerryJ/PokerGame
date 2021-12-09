PokerGame

Main Features:
- Simulate 2 players poker game


Card.java
- Suits include {lung, stone, tree, fork}
- Rank is between 5-20 (19 : henchman, 20 : boss)
- lung has weight 4, stone:3, tree: 2, fork 1
- Compare rank first then the suit weight (override compareTo method)
- String format: XX of XX: 14 of lungs

Deck.java
- Use ArrayList to store the cards
- Deck is composed of random cards
- Shuffle the cards
- Remove first card from the deck if drawing starts

Game.java
- p1 and p2 set score to 0 initially
- Shuffle the deck first
- The deck gave to each player 6 cards each round
- When a player places a card the same RANK as the most-recently-placed card (the card the
  other player just put down), then whoever’s card has a higher SUIT gets a point, and the round
  is over
- When the round is over, put all cards from the POT back into the DECK, shuffle the DECK,
  discard any cards left in the players’ HANDs, and deal both players new HANDs, and start a
  new round.
- If the deck has less than 12 cards, end the game


Check Assignment details for more information

Created by: Runde Jia (Jerry) 2018 Macquarie University.

Modified on VS CODE local desktop to test Github Merge
Desktop
<<<<<<< HEAD

2
3
ssss