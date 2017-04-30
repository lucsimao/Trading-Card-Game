package dm.cards;

import java.awt.Image;

import dm.cards.abstracts.NonMonsterCard;
import dm.constants.CardType;
import dm.constants.ColorPicture;
import dm.constants.SpellType;
import dm.exceptions.NoEffectException;
import dm.interfaces.NormalDeckCard;

/**Classe carta m�gica
 * Classe de Carta m�gica que serve para representar as Spells do jogo
 * Ela cont�m por padr�o o ColorPicture.Trap, que infere que a carta seja verde.
 * Ela n�o pode ter efeito nulo.
 * @author Sim�o
 */

public class SpellCard extends NonMonsterCard implements NormalDeckCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 511682576858461550L;
	
	public int type;

	public SpellCard(String name, String description, Image picture, Effect effect, int type, int copies_number)
			throws NoEffectException {
		super(name, description, CardType.SPELL, ColorPicture.SPELL, picture, effect, copies_number);
		this.type = type;
	}

	public SpellCard(int copies_number) throws NoEffectException {
		super(null, null, CardType.SPELL, ColorPicture.SPELL, null, new Effect(), copies_number);
		this.type = SpellType.NORMAL;
	}

	public int getType() {
		return type;
	}

}
