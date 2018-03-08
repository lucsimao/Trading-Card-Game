package dm.cards;

import dm.cards.abstracts.MonsterCard;
import dm.constants.ColorPicture;
import dm.constants.FilesConstants;
import dm.constants.MonsterAttribute;
import dm.constants.MonsterType;
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

	public MonsterEffectCard(String name, String description, String picture, MonsterType type, MonsterAttribute atribute,int level,
			int originalAttack, int originalDeffense, Effect effect, int copies_number)
			throws EffectMonsterWithNoEffectException {
		super(name, description, ColorPicture.NORMAL, picture, type, atribute,level, originalAttack, originalDeffense, effect,
				copies_number);
		if (effect == null)
			throw new EffectMonsterWithNoEffectException("An effect card needs to have a effect defined");
	}

	public MonsterEffectCard(String name, String description, MonsterType type, MonsterAttribute atribute,int level,
			int originalAttack, int originalDeffense, Effect effect, int copies_number)
			throws EffectMonsterWithNoEffectException {
		this(name, description,name + ".jpg", type, atribute,level, originalAttack, originalDeffense, effect,
				copies_number);
	}
	
	/**Gera um monstro aleat�rio*/
	public MonsterEffectCard() {
		super(nameGenerator(), "Texto padr�o", ColorPicture.NORMAL, FilesConstants.CARDS_IMG_DIR + FilesConstants.DEFAULT_MONTER_CARD_IMAGE, MonsterType.AQUA, MonsterAttribute.DARK,4, 0, 0, new Effect(), 3);
	}

}
