import java.util.Random;
/**
 * Playing deck comprising of 52 cards.
 */

/**
 * @author rakshith
 *
 */

public class StandardDeck extends Deck{
	
	private static final int shuffleCount = 1000;
	
	StandardDeck(){
		this.deckSize = 52;
		this.cards = new Card[this.deckSize];
		initializeDeck();
		shuffle();
	}
	
	@Override
	public void shuffle() {
		Random rand = new Random();
		for(int i=0; i<shuffleCount; i++){
			swap(rand.nextInt(this.deckSize), rand.nextInt(this.deckSize));
		}
	}

	private void swap(int from, int to) {
		Card temp = this.cards[from];
		this.cards[from] = this.cards[to];
		this.cards[to] = temp;
	}

	private void initializeDeck() {
		int i = 0;
		for(resourcePool.cardType type: resourcePool.cardType.values()){
			for(resourcePool.cardValue value: resourcePool.cardValue.values()){
				this.cards[i++] = new Card(type,value);
			}
		}
	}

	@Override
	public void printDeck() {
		for(Card card: this.cards){
			System.out.println(card);
		}
	}

}
