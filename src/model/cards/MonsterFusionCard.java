package model.cards;

import config.constants.ColorPicture;
import config.constants.FilesConstants;
import config.constants.MonsterAttribute;
import config.constants.MonsterType;
import model.cards.abstracts.MonsterCard;

/**
 * Classe Monstro de Fus�o. Representa os monstros de fus�o. Eles diferenciam o
 * tipo gen�rico e somente o extradeck poder� cont�-los. Sua cor ser� roxa. Eles
 * podem conter efeito nulo, caso sejam monstros normais e podem conter efeitos,
 * caso sejam de efeito.
 * 
 * @author Sim�o
 */

public class MonsterFusionCard extends MonsterCard implements ExtraDeckCard {

	private static final long serialVersionUID = -7850575761434909539L;

	public MonsterFusionCard(String name, String description, String picture, MonsterType type, MonsterAttribute atribute,int level,
			int originalAttack, int originalDeffense, int state, Effect effect, int copies_number) {
		super(name, description, ColorPicture.FUSION, picture, type, atribute,level, originalAttack, originalDeffense, effect,
				copies_number);
	}

	public MonsterFusionCard(String name, String description, MonsterType type, MonsterAttribute atribute,int level,
			int originalAttack, int originalDeffense, int state, Effect effect, int copies_number) {
		this(name, description,name + ".jpg", type, atribute,level, originalAttack, originalDeffense,state, effect,
				copies_number);
	}
	
	public MonsterFusionCard() {
		super(nameGenerator(), "Texto padr�o gerado", ColorPicture.FUSION, FilesConstants.CARDS_IMG_DIR + FilesConstants.DEFAULT_MONTER_CARD_IMAGE, MonsterType.AQUA, MonsterAttribute.DARK,4, 0, 0, null, 3);
	}

	public MonsterFusionCard(int copies_number) {
		super(nameGenerator(), "Texto padr�o gerado", ColorPicture.FUSION, FilesConstants.CARDS_IMG_DIR + FilesConstants.DEFAULT_MONTER_CARD_IMAGE, MonsterType.AQUA,MonsterAttribute.DARK,4, 0, 0, null, copies_number);
	}

}
