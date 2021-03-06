package dm.cards.abstracts;

import java.io.Serializable;
import java.util.Random;

import dm.cards.Effect;
import dm.constants.CardState;
import dm.constants.FilesConstants;
import dm.constants.RulesConstants;
import dm.exceptions.InvalidTextAttributeException;

/**
 * Classe abstrata Card, ela cont�m contrutor e m�todos que toda carta dever�
 * conter.
 * 
 * @author Sim�o
 */

public abstract class Card implements Serializable,Cloneable {

	private static final long serialVersionUID = -7720833260489417219L;

	private String name;
	private String description;
	private int cardType; // 0 for tokens, 1 for monster, 2 for spells, 3 for
							// traps
	private int colorPicture;
	protected String picture;
	private Effect effect;
	private int copies_number;
	private int state;

	public Card(String name, String description, int cardType, int colorPicture, String picture, Effect effect,
			int copies_number) {
		super();
		if (name == null || name.trim().isEmpty())
			throw new InvalidTextAttributeException("Name cannot be empty");
		if (description == null || description.trim().isEmpty())
			throw new InvalidTextAttributeException("Description cannot be empty");
		if (cardType < 0)
			throw new InvalidTextAttributeException("Card Type cannot be negative");
		if (colorPicture < 0)
			throw new InvalidTextAttributeException("Color Picture cannot be negative");
		if (description == null || description.trim().isEmpty())
			throw new InvalidTextAttributeException("Picture cannot be null");
		this.name = name;
		this.description = description;
		this.cardType = cardType;
		this.colorPicture = colorPicture;
		this.picture = picture;
		this.effect = effect;
		// Esse peda�o de c�digo protege de ter mais c�pias do que o permitido
		// nas regras do jogo.
		if (copies_number >= RulesConstants.MAX_CARDS_REPEATED)
			this.copies_number = RulesConstants.MAX_CARDS_REPEATED;
		else
			this.copies_number = copies_number;
		this.state = CardState.NONE;// Diz que a carta n�o est� no campo ainda.
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getDescription() {
		return description;
	}

	public int getColorPicture() {
		return colorPicture;
	}

	public String getPicture() {
		if (picture != null)
			return picture;
		else
			return FilesConstants.DEFAULT_MONTER_CARD_IMAGE;
	}

	public Effect getEffect() {
		return effect;
	}

	public int getCopiesNumber() {
		return copies_number;
	}

	@Override
	public boolean equals(Object card) throws NullPointerException {
		try {

			if (this.name.equals(((Card) card).getName()))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static String nameGenerator() {
		String s = "Carta - ";
		Random r = new Random();
		s = s + r.nextInt();
		return s;
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
}
