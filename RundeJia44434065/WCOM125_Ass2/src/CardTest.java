

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testSetSuit1() {
		// testing setSuit with lowercase inputs
		
		Card c = new Card();
		c.setSuit("bingo");
		assertEquals("fork", c.getSuit());
		
		c = new Card();
		c.setSuit("fork");
		assertEquals("fork", c.getSuit());
		
		c.setSuit("tree");
		assertEquals("tree", c.getSuit());
		
		c.setSuit("stone");
		assertEquals("stone", c.getSuit());
		
		c.setSuit("lung");
		assertEquals("lung", c.getSuit());
	}
	
	@Test
	public void testSetSuit2() {
		// testing setSuit with weird input cases
		
		Card c = new Card();
		
		c.setSuit("");
		assertEquals("fork", c.getSuit());
		
		c = new Card();
		c.setSuit("fORk");
		assertEquals("fork", c.getSuit());
		
		c.setSuit("trEE");
		assertEquals("tree", c.getSuit());
		
		c.setSuit("STONE");
		assertEquals("stone", c.getSuit());
		
		c.setSuit("Lung");
		assertEquals("lung", c.getSuit());
	}

	@Test
	public void testSetRank() {
		// testing setRank, including the input validation
		
		Card c = new Card();
		
		c.setRank(10);
		assertEquals(10, c.getRank());
		
		c = new Card();
		c.setRank(-5);
		assertEquals(5, c.getRank());
		
		c = new Card();
		c.setRank(3);
		assertEquals(5, c.getRank());
		
		c = new Card();
		c.setRank(0);
		assertEquals(5, c.getRank());
		
		c = new Card();
		c.setRank(20);
		assertEquals(20, c.getRank());
		
		c = new Card();
		c.setRank(21);
		assertEquals(20, c.getRank());
		
		c = new Card();
		c.setRank(31);
		assertEquals(20, c.getRank());
	}

	@Test
	public void testDefaultConstructor() {
		// testing the default constructor
		Card c = new Card();
		assertEquals("fork", c.getSuit());
		assertEquals(5, c.getRank());
	}
	
	
	@Test
	public void testParameterisedConstructor() {
		// testing the parameterised constructor, including input validation
		
		Card c0 = new Card("tree", 10);
		assertEquals(c0.getSuit(), "tree");
		assertEquals(c0.getRank(), 10);
		
		c0 = new Card("fork", 30);
		assertEquals(c0.getSuit(), "fork");
		assertEquals(c0.getRank(), 20);
		
		
		c0 = new Card("Stone", 18);
		assertEquals(c0.getSuit(), "stone");
		assertEquals(c0.getRank(), 18);
		
		
		// check that parameterised constructor does
		// the same as using setters, with lots of input data
		Card c1;
		Card c2;
		for (String s: new String[]{"fork", "tree", "stone", "lung", "mongoose"}) {
			for (int r=0; r<35; r++) {
				c1 = new Card();
				c1.setSuit(s);
				c1.setRank(r);
				c2 = new Card(s, r);
				
				assertEquals(c1.getRank(), c2.getRank());
				assertEquals(c1.getSuit(), c2.getSuit());
				
			}
		}
	}

	@Test
	public void testCompareTo1() {
		// testing compareTo with the same suit
		// note, you need your parameterised constructor
		// working for this test to pass.
		
		Card c1 = new Card("fork", 5);
		Card c2 = new Card("fork", 9);
		Card c3 = new Card("fork", 12);
		Card c4 = new Card("fork", 15);
		Card c5 = new Card("fork", 15);
		
		assertEquals(0,  c1.compareTo(c1));
		assertEquals(-1, c1.compareTo(c2));
		assertEquals(-1, c1.compareTo(c3));
		assertEquals(-1, c1.compareTo(c4));
		assertEquals(-1, c1.compareTo(c5));
		
		assertEquals(1,  c2.compareTo(c1));
		assertEquals(0,  c2.compareTo(c2));
		assertEquals(-1, c2.compareTo(c3));
		assertEquals(-1, c2.compareTo(c4));
		assertEquals(-1, c2.compareTo(c5));
		
		assertEquals(1,  c3.compareTo(c1));
		assertEquals(1,  c3.compareTo(c2));
		assertEquals(0,  c3.compareTo(c3));
		assertEquals(-1, c3.compareTo(c4));
		assertEquals(-1, c3.compareTo(c5));
		
		assertEquals(1,  c4.compareTo(c1));
		assertEquals(1,  c4.compareTo(c2));
		assertEquals(1,  c4.compareTo(c3));
		assertEquals(0,  c4.compareTo(c4));
		assertEquals(0,  c4.compareTo(c5));
	}

	@Test
	public void testCompareTo2() {
		// testing compareTo with different suits
		// note, you need your parameterised constructor
		// working for this test to pass.
		
		Card c1 = new Card("lung", 8);
		Card c2 = new Card("lung", 12);
		Card c3 = new Card("stone", 8);
		Card c4 = new Card("fork", 14);
		Card c5 = new Card("fork", 14);
		
		assertEquals(0,  c1.compareTo(c1));
		assertEquals(-1, c1.compareTo(c2));
		assertEquals(1,  c1.compareTo(c3));
		assertEquals(-1, c1.compareTo(c4));
		assertEquals(-1, c1.compareTo(c5));
		
		assertEquals(1,  c2.compareTo(c1));
		assertEquals(0,  c2.compareTo(c2));
		assertEquals(1,  c2.compareTo(c3));
		assertEquals(-1, c2.compareTo(c4));
		assertEquals(-1, c2.compareTo(c5));
		
		assertEquals(-1, c3.compareTo(c1));
		assertEquals(-1, c3.compareTo(c2));
		assertEquals(0,  c3.compareTo(c3));
		assertEquals(-1, c3.compareTo(c4));
		assertEquals(-1, c3.compareTo(c5));
		
		assertEquals(1,  c4.compareTo(c1));
		assertEquals(1,  c4.compareTo(c2));
		assertEquals(1,  c4.compareTo(c3));
		assertEquals(0,  c4.compareTo(c4));
		assertEquals(0,  c4.compareTo(c5));
		
	}

	@Test
	public void testGetSuitWeight() {
		Card c1 = new Card("lung", 5);
		Card c2 = new Card("stone", 15);
		Card c3 = new Card("tree", 19);
		Card c4 = new Card("fork", 10);
		assertEquals(4, c1.getSuitWeight());
		assertEquals(3, c2.getSuitWeight());
		assertEquals(2, c3.getSuitWeight());
		assertEquals(1, c4.getSuitWeight());
		
	}
	
	@Test
	public void testToString1() {
		Card c1 = new Card("lung", 5);
		Card c2 = new Card("stone", 15);
		Card c3 = new Card("tree", 7);
		Card c4 = new Card("fork", 14);
		assertEquals("5 of lungs", c1.toString());
		assertEquals("15 of stones", c2.toString());
		assertEquals("7 of trees", c3.toString());
		assertEquals("14 of forks", c4.toString());
		
	}
	
	@Test
	public void testToString2() {
		Card c1 = new Card("lung", 17);
		Card c2 = new Card("stone", 18);
		Card c3 = new Card("tree", 19);
		Card c4 = new Card("fork", 20);
		assertEquals("17 of lungs", c1.toString());
		assertEquals("18 of stones", c2.toString());
		assertEquals("henchman of trees", c3.toString());
		assertEquals("boss of forks", c4.toString());
	}
}
