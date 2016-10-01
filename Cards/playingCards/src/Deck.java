/**
 * Playing deck abstract class.
 */

/**
 * @author rakshith
 *
 */

public abstract class Deck {
	public Card[] cards;
	public int deckSize;
	public abstract void shuffle();
	public abstract void printDeck();
}
