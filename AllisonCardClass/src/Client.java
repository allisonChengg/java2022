
public class Client {
	
	public static void main(String[] args) {
		Card card = new Card(SUIT.HEARTS, RANK.SEVEN);
		
		System.out.println(card.isFaceUp());
		card.flip(); 
		System.out.println(card.isFaceUp());
		//System.out.println(card);
		
		for (SUIT s : SUIT.values()) {
			for (RANK r : RANK.values()) {
				Card c = new Card(s, r);
				System.out.println(c);
			}
		}
		
		Deck deck = new Deck();
		Deck myDeck = new Deck(50);
		
		System.out.println(deck.numberInDeck());
		
		System.out.println(myDeck.isEmpty());
		


	}

}
