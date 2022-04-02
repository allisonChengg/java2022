import java.util.*;

/*
 * Allison Cheng
 * Deck:
 * 
 * Answer: The copy ensures that the Card within our deck won't be 
 * changed by the client program.
 */

public class Deck {
	private Card[] myCards;
	private int numInDeck;
	
	public Deck() {
		
		myCards = new Card[52];
		for (int i = 0; i < myCards.length; i++) {
			int suit = i / 13;
			int rank = i % 13;
			
			Card c = new Card(SUIT.values()[suit], RANK.values()[rank]);
			myCards[i] = c;
		}
	}
	
	public Deck(int max) {
		myCards = new Card[max];
	}
	
	public int numberInDeck() {
		return numInDeck;
	}
	
	public boolean isEmpty() {
		
		if (myCards.length == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		
		if (numberInDeck() == myCards.length) {
			return true;
		}
		return false;
	}
	
	public void addToBottom(Card toAdd) {
		
		if (isFull()) {
			throw new IllegalStateException("Deck already full");
		}
		
		Card copy = new Card(toAdd);
		
		if(!copy.isFaceUp()) {
			copy.flip();
		}
		
		myCards[numInDeck] = copy;
		numInDeck++;
	}
	
	public Card dealFromTop() {
		
		if (isEmpty()) {
			throw new NoSuchElementException("Deck Empty");
		}
		
		Card topCard = myCards[0];
		for (int i = 0; i < myCards.length - 1; i++) {
			myCards[i] = myCards[i + 1];
		}
		numInDeck--;
		
		return topCard;
	}
	
	public void shuffle(int numTimes) {
		
		for (int i = 0; i < numTimes; i++) {
			
			int randNum1 = (int) (Math.random() * myCards.length);
			int randNum2 = (int) (Math.random() * myCards.length);
			
			Card temp = myCards[randNum1];
			myCards[randNum1] = myCards[randNum2];
			myCards[randNum2] = temp;
		}
	}
	
	public void order() {	
		
		//outer loop set up so that we don't re-examine largest element twice
		for(int n = numInDeck; n >= 2; n--){
			
			int maxIndex = 0;   // location of the best index
			
			
			//initially examines entire array,then one less, then two less,....
			//finds the largest element in scanned portion
			for(int i = 1; i < n; i++) {
				
				if(myCards[i].compareTo(myCards[maxIndex]) > 0)
					maxIndex = i;
			
				//swap the largest value with where it belongs in the array
			
				Card tempSwap = myCards[maxIndex];
				myCards[maxIndex] = myCards[n - 1];
				myCards[n - 1] = tempSwap;
			
			}
		}
		
	
	}
	
	
}
