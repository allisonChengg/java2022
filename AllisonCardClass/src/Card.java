/*
 * Allison Cheng
 * Card Class: playing card with suit and rank type that faces up or down
 */

public class Card {
	private SUIT suit;
	private RANK rank;
	private boolean faceUp;
	
	public Card(SUIT s, RANK r) {
		suit = s;
		rank = r;
		faceUp = false;
	}
	
	public Card(Card other) {
		this(other.suit, other.rank);
	}
	
	public SUIT getSuit() {
		return suit;
	}
	
	public RANK getRank() {
		return rank;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	// flips the card over
	public void flip() {
		faceUp = !faceUp;
	}
	
	// returns unique number [0, 51] based off rank & suit
	public int cardValue() {
		return rank.ordinal() + suit.ordinal() * 13;
	}
	
	// compares 2 cards to see if identical
	public boolean equals(Card other) {
		if (this.cardValue() == other.cardValue()) {
			return true;
		}
		return false;
	}
	
	// compares 2 cards to see if same value
	public int compareTo(Card other) {
		int realDiff = this.cardValue() - other.cardValue();
		
		return realDiff;
	}
	
	public String toString() {
		if (isFaceUp()) {
			return rank + " of " + suit;
		}
		else {
			return "Unknown";
		}
	}

}