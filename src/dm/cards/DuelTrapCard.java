package dm.cards;

import java.awt.Image;

import dm.cards.abstracts.NonMonsterCard;
import dm.constants.CardType;
import dm.constants.ColorPicture;
import dm.interfaces.NormalDeckCard;

public class DuelTrapCard extends NonMonsterCard implements  NormalDeckCard  {
	/*Classe carta armadilha*/
	public int type;

	public DuelTrapCard(String name, String description, Image picture, Effect effect,
			int type,int copies_number) {
		super(name, description,CardType.TRAP,ColorPicture.TRAP, picture, effect,copies_number);
		this.type = type;
	}
}
