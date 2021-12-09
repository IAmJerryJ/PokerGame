//Runde Jia 44434065

public class Card {
	public static final String[] validSuits = {"lung", "stone", "tree", "fork"};
	
	private String suit;
	private int rank;
	
	public String getSuit() {
		return suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	/**
	 * Set the instance variable suit to the given parameter.
	 * If the parameter is not one of the valid suits (from validSuits above),
	 * set the instance variable to "fork".
	 * 
	 * Note: the parameter may be in a different case; so "stone", "Stone", "STONE",
	 * should all result in an instance variable value of "stone".
	 */
	public void setSuit(String suit) {
		boolean flag = false;							//set flag to make sure second "if" only happens when the loop finished
		for(int i = 0; i < validSuits.length; i ++) {
			if(suit.toLowerCase().equals(validSuits[i]))  
			{
				this.suit = validSuits[i];					// set suit to the default 
				flag = true;								//stop making suit to "fork"
				}
			if((suit.toLowerCase() != validSuits[i]) && (flag == false))		// check if parameter not found, set it to "fork"
				this.suit = "fork";
		}
			//to be completed
	}
	
	/**
	 * Set the instance variable rank to the given parameter.
	 * If the given parameter is less than 5, instance variable should become 5.
	 * If the given parameter is more than 20, the instance variable should become 20.
	 */
	public void setRank(int rank) {
		if(rank < 5)							// if rank less than 5, set it to 5
			this.rank = 5;
		else if(rank >20)
			this.rank = 20;						// if rank greater than 20, set it to 20
		else	
			this.rank = rank;					//if rank is in the range, don't change rank
		//to be completed
	}
	
	/**
	 * Parameterised constructor.
	 * Assigns values to instance variable using the above setters.
	 */
	public Card(String suit, int rank) {
		setSuit(suit);								//give value to suit and rank
		setRank(rank);
		//to be completed
	}
	
	/**
	 * Default constructor.
	 * Make this card the 5 of forks.
	 */
	public Card() {
		setSuit("fork");						// set default value of suit and rank
		setRank(5);
		//to be completed
	}

	/**
	 * 
	 * @return 4 if lung, 3 if stone, 2 if tree, 1 if fork
	 * This method will be useful for using in compareTo 
	 */
	public int getSuitWeight() {
		if(this.getSuit().equals("lung"))				//if suit is lung,stone, tree or fork, give correct weight
			return 4;
		if(this.getSuit().equals("stone"))
			return 3;
		if(this.getSuit().equals("tree"))
			return 2;
		if(this.getSuit().equals("fork"))
			return 1;
		//to be completed
		return 0;
		
	}

	/**
	 * 
	 * @return 1 if the calling object beats parameter object.
	 * -1 if the calling object is beaten by the parameter object.
	 * 0 if the calling object is the same as parameter object.
	 * 
	 * Basis of comparison:
	 * - The card with the higher rank wins.
	 * - If the ranks are the same, lung beats stone, stone beats tree, tree beats fork.
	 * - If the suits AND ranks are the same, return 0
	 * 
	 */
	public int compareTo(Card other) {
		if(this.getRank() > other.getRank())						//compare called rank and other rank
			return 1;
		if(this.getRank() < other.getRank())
			return -1;
		else {
			if(this.getSuitWeight() > other.getSuitWeight())			//if ranks are same, compare suit weight
				return 1;
			if(this.getSuitWeight() < other.getSuitWeight())
				return -1;
		}
		//to be completed
		return 0;
	}
	
	/**
	 * @return a String describing the card.
	 * For example, if rank=8 and suit="tree", return "8 of trees".
	 * 
	 * Further, the ranks 19 and 20 are called "henchman" and "boss" respectively,
	 * so if rank=19 and suit="lung", return "henchman of lungs".
	 * 
	 */
	public String toString() {
		//to be completed
		if(this.getRank() < 19)
		return this.getRank() + " of " + this.getSuit() + "s";			//if rank is under 19, make it to string
		else if(this.getRank() == 19)
			return "henchman of " + this.getSuit() + "s";				//if rank is 19, set it to "henchman"
		else
			return "boss of " + this.getSuit() + "s";					//if rank is 20, set it to "boss"
		
	}
	
}
