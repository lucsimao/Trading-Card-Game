package dm.fields.elements.decks;

import dm.cards.abstracts.Card;
import dm.exceptions.MaxCardCopiesException;
import dm.exceptions.MaxDeckSizeException;
import dm.interfaces.ExtraDeckCard;

/*From @Simao
 * Deck Extra, diferente do deck comum, ela s� pode receber monstros de extra deck.
 * */

public class ExtraDeck extends Deck<ExtraDeckCard>{

	private static final int MAX_CARDS = 15;

	// Adiciona uma carta ao deck
	@Override
	public void putCard(ExtraDeckCard card) {
		if(getCards().size()<=MAX_CARDS)
			if (countCards(card) < (card).getCopiesNumber())
				getCards().push(card);
			else
				throw new MaxCardCopiesException("You can only have " + ((Card) card).getCopiesNumber() + " copies of this card");
		else
			throw new MaxDeckSizeException("You can have only " + MAX_CARDS + " cards on your deck");		
	}

	public boolean isPlayable() {
		return (this.size()<= MAX_CARDS);
	}

	public int getMaxCards() {
		return MAX_CARDS;
	}
	
}
