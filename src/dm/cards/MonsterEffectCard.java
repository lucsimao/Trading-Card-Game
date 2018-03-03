package dm.cards;

import dm.cards.abstracts.MonsterCard;
import dm.constants.ColorPicture;
import dm.constants.FilesConstants;
import dm.constants.MonsterAttribute;
import dm.exceptions.EffectMonsterWithNoEffectException;
import dm.interfaces.NormalDeckCard;

/**
 * * Esta classe representa monstros de efeito do jogo de cartas. Sua cor �
 * alaranjada. Al�m de permitir ser utilizada no tipo gen�rico, ela tem a
 * restri��o de n�o permitir que um monstro tenha efeito nulo. Diferente de um
 * monstro de tipo normal.
 * 
 * @author Sim�o
 */

public class MonsterEffectCard extends MonsterCard implements NormalDeckCard {

	private static final long serialVersionUID = 5346230125931311515L;

	public MonsterEffectCard(String name, String description, String picture, int type, MonsterAttribute atribute,
			int originalAttack, int originalDeffense, Effect effect, int copies_number)
			throws EffectMonsterWithNoEffectException {
		super(name, description, ColorPicture.NORMAL, picture, type, atribute, originalAttack, originalDeffense, effect,
				copies_number);
		if (effect == null)
			throw new EffectMonsterWithNoEffectException("An effect card needs to have a effect defined");
	}

	public MonsterEffectCard() {
		super(nameGenerator(), "Texto padr�o", ColorPicture.NORMAL, FilesConstants.CARDS_IMG_DIR + FilesConstants.DEFAULT_MONTER_CARD_IMAGE, 0, MonsterAttribute.DARK, 0, 0, new Effect(), 3);
	}

}
