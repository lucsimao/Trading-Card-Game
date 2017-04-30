package dm.cards.abstracts;

import java.awt.Image;

import dm.cards.Effect;
import dm.exceptions.NoEffectException;

/**
 * Cartas que n�o s�o monstros, ou seja, m�gicas e armadilhas.
 * Elas s�o obrigadas a ter efeitos.
 *@author Sim�o */

public abstract class NonMonsterCard extends Card {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonMonsterCard(String name, String description, int cardType, int colorPicture, Image picture, Effect effect,
			int copies_number) throws NoEffectException {
		super(name, description, cardType, colorPicture, picture, effect, copies_number);
		if (effect == null)
			throw new NoEffectException("An effect card needs to have a effect defined");
	}

}
