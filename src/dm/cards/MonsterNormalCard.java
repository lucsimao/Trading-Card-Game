package dm.cards;

import dm.cards.abstracts.MonsterCard;
import dm.constants.ColorPicture;
import dm.constants.FilesConstants;
import dm.constants.MonsterAttribute;
import dm.constants.MonsterType;
import dm.interfaces.NormalDeckCard;

/**
 * Classe Monstro normal, representa monstros sem efeito. Sua cor � amarelada.
 * Ela n�o cont�m efeitos no construtor, portanto, seu efeito sempre ser� null.
 * 
 * @author Sim�o
 */

public class MonsterNormalCard extends MonsterCard implements NormalDeckCard {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2858687724595096561L;

	public MonsterNormalCard(String name, String description, String picture, MonsterType spellcaster, MonsterAttribute attribute,
			int originalAttack, int originalDeffense, int copies_number) {
		super(name, description, ColorPicture.NORMAL, picture, spellcaster, attribute, originalAttack, originalDeffense, null,
				copies_number);
	}

	public MonsterNormalCard() {
		super(nameGenerator(), "Carta padr�o para testes", ColorPicture.NORMAL,  FilesConstants.DEFAULT_MONTER_CARD_IMAGE, MonsterType.AQUA, MonsterAttribute.DARK, 0, 0, null, 3);
		// System.out.println("carta criada " + nameGenerator());
	}

	public MonsterNormalCard(int copies_number) {
		super(nameGenerator(), "Carta padr�o para testes", ColorPicture.NORMAL, FilesConstants.DEFAULT_MONTER_CARD_IMAGE, MonsterType.AQUA, MonsterAttribute.DARK, 0, 0, null, copies_number);
	}

}
