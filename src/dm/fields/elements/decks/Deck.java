package dm.fields.elements.decks;

/** Classe abstrata deck, para ter fun��es especiais de todos os decks.
 * Al�m disso, ele herda de elemento de campo, uma vez que um campo possui um deck.
 * @author Sim�o
 * */

public abstract class Deck<GenericCard> extends FieldElement<GenericCard> {

	public Deck(int number, GenericCard card) {
		super(number, card);
	}

	public Deck() {
		super();
	}

	// Verifica se o deck est� vazio
	public boolean isDeckout() {
		return isEmpty();
	}

	// Compra uma carta do baralho
	public GenericCard drawCard() {
		return removeFromTop();
	}

}
