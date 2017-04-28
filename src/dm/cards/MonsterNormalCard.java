package dm.cards;

import java.awt.Image;

import dm.cards.abstracts.MonsterCard;
import dm.constants.ColorPicture;
import dm.interfaces.NormalDeckCard;

/**
 * Classe Monstro normal, representa monstros sem efeito.
 * Sua cor � amarelada.
 * Ela n�o cont�m efeitos no construtor, portanto, seu efeito sempre ser� null.
 *@author Sim�o */

public class MonsterNormalCard extends MonsterCard implements NormalDeckCard {

	public MonsterNormalCard(String name, String description, Image picture, int type, int atribute, int originalAttack,
			int originalDeffense, int state, int copies_number) {
		super(name, description, ColorPicture.NORMAL, picture, type, atribute, originalAttack, originalDeffense, null,
				copies_number);
	}

	public MonsterNormalCard(int copies_number) {
		super(null, null, ColorPicture.NORMAL, null, 0, 0, 0, 0, null, copies_number);
	}
}
