package dm.fields.elements;

import dm.cards.abstracts.Card;
import dm.fields.elements.decks.Deck;

/*From @Simao
 * Uma classe para tratar os monstros removidos de jogo.
 * Ele n�o tem nada de especial, mas � diferenciada por conta de seu uso.
 * */

public class RemoveFromPlay extends Deck<Card> {
	@Override
	public void putCard(Card card) {
		getCards().push(card);
	}

}
