package dm.fields.elements.decks;

/*From @Simao
 * Classe abstrata deck, para ter fun��es especiais de todos os decks.
 * Al�m disso, ele herda de elemento de campo, uma vez que um campo possui um deck.
 * */

public abstract class Deck<GenericCard> extends FieldElement<GenericCard>{

	// Verifica se o deck est� vazio
	public boolean isDeckout() {
		return isEmpty();
	}
	
	// Compra uma carta do baralho
	public GenericCard drawCard() {
		return removeFromTop();
	}
		
}
