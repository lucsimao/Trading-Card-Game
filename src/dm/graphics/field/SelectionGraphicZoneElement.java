package dm.graphics.field;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.lang.Thread.State;

import dm.cards.abstracts.MonsterCard;
import dm.constants.CardState;
import dm.constants.FilesConstants;
import dm.exceptions.CardNotFoundException;
import dm.fields.elements.zones.CardZone;
import dm.graphics.Screen;

public class SelectionGraphicZoneElement extends SelectionGraphicElement {

	private CardZone cardZone;
	private int index;

	private CardDetailsGraphic cardDetailsGraphic;
	
	public SelectionGraphicZoneElement(int x, int y, int width, int height, float alpha, Color color, CardZone cardZone,
			int index) {
		super(x, y, width, height, alpha, color);
		this.cardZone = cardZone;
		this.index = index;
	}

	public SelectionGraphicZoneElement(CardDetailsGraphic cardDetailsGraphic,int x, int y, int width, int height, CardZone cardZone, int index) {
		super(x, y, width, height);
		this.cardZone = cardZone;
		this.index = index;
		this.cardDetailsGraphic = cardDetailsGraphic;
	}

	@Override
	public void drawItself(Screen screen) {
		super.drawItself(screen);
		try {
			switch (cardZone.getCard(index).getState()) {
				case CardState.FACE_UP_ATTACK :
					screen.imageScaled(FilesConstants.CARDS_IMG_DIR + cardZone.getCard(index).getPicture(), 0, 0, getWidth()*8/9, getHeight()*8/9, 0, getX() + getWidth()/18 , getY() + getHeight()/18,
							1f);
					break;
				case CardState.FACE_UP_DEFENSE_POS : 
					screen.imageScaled(FilesConstants.CARDS_IMG_DIR + cardZone.getCard(index).getPicture(), 0, 0, getWidth()*8/9, getHeight()*8/9, Math.PI*3/2, getX() + getWidth()/18 , getY() + getHeight()/18,
							1f);
					break;
				case CardState.FACE_DOWN: 
					if(cardZone.getCard(index) instanceof MonsterCard) {
						screen.imageScaled(FilesConstants.CARDS_IMG_DIR + FilesConstants.FACE_DOWN_CARD, 0, 0, getWidth()*8/9, getHeight()*8/9, Math.PI*3/2, getX() + getWidth()/18 , getY() + getHeight()/18,
							1f);
					}
					else 
						screen.imageScaled(FilesConstants.CARDS_IMG_DIR + FilesConstants.FACE_DOWN_CARD, 0, 0, getWidth()*8/9, getHeight()*8/9,0, getX() + getWidth()/18 , getY() + getHeight()/18,
								1f);
					break;
			}
				
		
		} catch (CardNotFoundException e2) {
			System.out.println("Zona " + index + " n�o possui cartas no momento");
		} catch (Exception e) {
			System.out.println("SELECTIONGRAPHIC - Exce��o n�o esperada " + cardZone.getCard(index).getPicture());
			e.printStackTrace();
		}
	}
	@Override
	public void hoverAction(MouseEvent mouseEvent) {
//		System.out.println(thread.getState());
		int x = mouseEvent.getX();
		int y = mouseEvent.getY();

		if (x >= getX() && x <= getX() + getWidth()) {
			if ((y >= getY() && y <= getY() + getHeight())) {
				if (thread.getState().equals(State.NEW) || thread.getState().equals(State.TERMINATED)) {
//					System.out.println("SELECTIONGRAPHIC - Chamando thread");
					try {
						cardDetailsGraphic.setCard(cardZone.getCard(index));;
					} catch (Exception e) {
						// TODO: handle exception
					}
					blinkAnimation();
				}
		
			}else {
				setAlpha(0);
				thread.stop();
			}
				
		} else {
//			System.out.println("SELECTIONGRAPHIC - Parando Thread");
			setAlpha(0);
			thread.stop();
		}
	}
}
