package dm.graphics.field;

import java.awt.Color;
import java.awt.event.MouseEvent;

import dm.cards.abstracts.Card;
import dm.cards.abstracts.MonsterCard;
import dm.constants.FilesConstants;
import dm.graphics.Screen;

public class CardDetailsGraphic extends ElementGraphic {

	private Card card;
	
	public CardDetailsGraphic( int x, int y, int width, int height) {
		super(null, x, y, width, height);
		this.card = null;
	}
	
	public CardDetailsGraphic( int x, int y, int width, int height,float alpha) {
		super(null, x, y, width, height,alpha);
		this.card = null;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public Card getCard() {
		return card;
	}
	
	@Override
	public void drawItself(Screen screen) {
		
		int card_width = Math.round(getWidth()*178f/900);
		int card_height = Math.round(getHeight()*250f/650);
		int card_x = Math.round(getWidth()*10f/900);
		int card_y = Math.round(getHeight()*45f/650);
		
		int text_x = Math.round(getWidth()*15f/900);
//		int text_y;
		
		screen.imageScaled(FilesConstants.THEME_PATH + "tabControl.png",0,0,getWidth()*2/9 - 10,Math.round(getHeight()*340f/650),0,Math.round(getWidth()*5f/900),Math.round(getHeight()*300f/650),1);
		screen.imageScaled(FilesConstants.THEME_PATH + "darkTab.png",0,0,getWidth()*2/9 - 10,Math.round(getHeight()*35f/650),0,Math.round(getWidth()*5f/900),Math.round(getHeight()*300f/650),1);
		if(card == null || card.getPicture() == null) {
			screen.imageScaled(FilesConstants.CARDS_IMG_DIR + FilesConstants.FACE_DOWN_CARD,0,0,card_width,card_height,0,card_x,card_y,1);
			
		}else {
			screen.imageScaled(FilesConstants.CARDS_IMG_DIR + card.getPicture(),0,0,card_width,card_height,0,card_x,card_y,1);

			screen.text(card.getName().toUpperCase(),text_x,Math.round(getHeight()*322f/650),12,Color.WHITE);
			if(card instanceof MonsterCard) {
//				screen.text(((MonsterCard)card).getType(),15,350,12,Color.BLACK);
//				screen.text("Attribute DARK",15,361,12,Color.BLACK);
//				screen.text("Level " + ((MonsterCard)card),15,372,12,Color.BLACK);
				screen.text(((MonsterCard)card).getOriginalAttack() + " / " + ((MonsterCard)card).getOriginalDefense(), text_x,Math.round(getHeight()*383f/650),12,Color.BLACK);
			}
			screen.textMultiLine(card.getDescription(),text_x,Math.round(getHeight()*404f/650),12,getWidth()*2/9 - 30,Color.BLACK);
		}

		

//		screen.textMultiLine();
//		screen.textMultiLine("When you have \"Right Arm of the Forbidden One\",\"Left Arm of the Forbidden One\",\"Right Leg of the Forbidden One\",\"Left Leg of the Forbidden One\", in addition to this card in your hand, you win the duel. ",15,404,12,getWidth()*2/9 - 30,Color.BLACK);

	}
	
	@Override
	public void hoverAction(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAction(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pressedAction(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		
	}

}
