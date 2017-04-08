package dm.cards.abstracts;

import java.awt.Image;

import dm.cards.Effect;
import dm.constants.CardState;
import dm.constants.RulesConstants;

/*
 * From @Simao
 * Classe abstrata Card, ela cont�m contrutor e m�todos que toda carta dever� conter.
 * */

public abstract class Card {
	
	private String name;
	private String description;
	private int cardType; // 0 for tokens, 1 for monster, 2 for spells, 3 for traps
	private int colorPicture;
	private Image picture;
	private Effect effect;
	private int copies_number;
	private int state;
	
	public Card(String name, String description, int cardType, int colorPicture, Image picture, Effect effect, int copies_number) {
		super();
		this.name = name;
		this.description = description;
		this.cardType = cardType;
		this.colorPicture = colorPicture;
		this.picture = picture;
		this.effect = effect;
		//Esse peda�o de c�digo protege de ter mais c�pias do que o permitido nas regras do jogo.
		if(copies_number>=RulesConstants.MAX_CARDS_REPEATED)
			this.copies_number = RulesConstants.MAX_CARDS_REPEATED;
		else
			this.copies_number = copies_number;
		this.state = CardState.NONE;//Diz que a carta n�o est� no campo ainda.
	}

	//Getters and Setters
	public String getName() {return name;}
	public int getState() {return state;}
	public void setState(int state) {this.state = state;}
	public int getCardType() {return cardType;}
	public void setCardType(int cardType) {this.cardType = cardType;}
	public String getDescription() {return description;}
	public int getColorPicture() {return colorPicture;}
	public Image getPicture() {return picture;}
	public Effect getEffect() {return effect;}
	public int getCopiesNumber() {return copies_number;}
	
}
