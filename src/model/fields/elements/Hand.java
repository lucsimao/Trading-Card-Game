package model.fields.elements;

import model.cards.MonsterNormalCard;
import model.cards.NormalDeckCard;
import model.cards.abstracts.Card;
import model.cards.abstracts.MonsterCard;
import model.fields.elements.decks.FieldElement;

/**
 * Classe M�o. Ela pode ter um n�mero m�ximo de cartas na m�o. Possui fun��es de
 * descatar, adicionar e remover cartas.
 * 
 * @author Sim�o
 */

public class Hand extends FieldElement<Card> {

	private static final long serialVersionUID = 1L;

	private final int MAX_CARDS = 7;

	private int maxCards;
	private boolean isHandPlayable;

	public Hand() {
		this.maxCards = MAX_CARDS;
		isHandPlayable = true;
	}

	public Hand(int number) {
		super(number, new MonsterNormalCard());
		this.maxCards = MAX_CARDS;
		isHandPlayable = true;

	}

	@Override
	public void putCard(Card card) {
		getCards().push(card);
		if (getCards().size() <= maxCards)
			isHandPlayable = true;
		else
			isHandPlayable = false;
	}

	public Card discard(Card card) {
		if (getCards().size() <= maxCards)
			isHandPlayable = false;
		else
			isHandPlayable = true;
		return remove(card);
	}

	public boolean isHandPlayable() {
		return isHandPlayable;
	}

	public void setMaxCards(int maxCards) {
		this.maxCards = maxCards;
	}

	public int getMaxCards() {
		return this.maxCards;
	}

	public Card discardFirst() {
		if (getCards().size() <= maxCards)
			isHandPlayable = false;
		else
			isHandPlayable = true;
		return removeFromTop();

	}
}
