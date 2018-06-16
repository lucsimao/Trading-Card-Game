package model.fields.elements;

import model.cards.MonsterNormalCard;
import model.cards.abstracts.Card;
import model.fields.elements.decks.Deck;

/**
 * Classe cemit�rio, ela n�o possui nada de diferente em sua estrutura, por�m,
 * deve ser diferenciada por conta de seu uso.
 * 
 * @author Sim�o
 */
public class Graveyard extends Deck<Card> {

	private static final long serialVersionUID = 7173474563513436801L;

	public Graveyard(int number) {
		super(number, new MonsterNormalCard());
	}

	public Graveyard() {
		super();
	}

	@Override
	public void putCard(Card card) {
		getCards().push(card);
	}

}
