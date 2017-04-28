package dm.fields.elements.decks;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

import dm.exceptions.CardNotFoundException;
import dm.exceptions.CardsOutException;

/**
 * SuperClasse abstrata Elemento de Campo, ela � a m�e de todos os elementos.
 * Possui os m�todos padr�o que todos os elementos devem ter.
 * @author Sim�o*/
public abstract class FieldElement<GenericCard> {

	// Atributos
	private Stack<GenericCard> cards;// Uma pilha que representas as cartas
										// contidas nesse elemento

	// Construtor b�sico de inicializa��o
	public FieldElement() {
		cards = new Stack<>();
	}

	public FieldElement(int number, GenericCard card) {
		cards = new Stack<>();
		for (int i = 0; i < number; i++) {
			putCard(card);
		}
	}

	// Retorna a lista de cartas da pilha.
	// Ele � protegido, pois somente filhos pode acess�-la.
	protected Stack<GenericCard> getCards() {
		return cards;
	}

	// Mostra a carta no topo da pilha
	public GenericCard top() {
		return getCards().peek();
	}

	// Embaralha a pilha
	public void shuffle() {
		Collections.shuffle(getCards());
	}

	// Retorna o tamanho da pilha
	public int size() {
		return getCards().size();
	}

	// Verifica se a pilha est� vazia
	public boolean isEmpty() {
		return getCards().isEmpty();
	}

	// M�todo para contar as cartas na pilha
	public int countCards(GenericCard card) {
		Iterator<GenericCard> i = getCards().iterator();
		int number = 0;
		while (i.hasNext()) {
			if (i.next().equals(card))
				number++;
		}
		return number;
	}

	// M�todo que utiliza remove e push para levar uma carta qualquer para o
	// topo da pilha
	public void moveCardToTop(GenericCard card) {
		Stack<GenericCard> cards = this.getCards();
		if (cards.contains(card)) {
			cards.remove(card);
			cards.push(card);
		} else
			throw new CardNotFoundException("Card not found on this deck");
	}

	// M�todo que remove uma carta qualquer da pilha
	public GenericCard remove(GenericCard card) {
		if (getCards().contains(card)) {
			getCards().remove(card);
			return card;
		}
		throw new CardNotFoundException("This card does not exist in this deck");
	}

	// M�todo que remove uma carta do in�cio da pilha (pop)
	public GenericCard removeFromTop() {
		if (getCards().size() == 0)
			throw new CardsOutException("Empty deck.");
		else
			return getCards().pop();
	}

	// M�todo abstrato que representa colocar uma carta na pilha, cada classe
	// deve
	// implement�-la de forma diferente.
	public abstract void putCard(GenericCard card);

}
