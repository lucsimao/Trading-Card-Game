package dm.graphics;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;

import dm.cards.MonsterEffectCard;
import dm.cards.abstracts.Card;
import dm.constants.FilesConstants;
import dm.fields.Field;
import dm.fields.elements.decks.ExtraDeck;
import dm.fields.elements.decks.NormalDeck;
import dm.game.Player;

public class Yugioh extends Game{

	private final int card_width  = Math.round(getWidth()/27.69f);
	private final int card_height = Math.round(getHeight()/11.7f) ;
	private final int card_dis_x  = Math.round(getWidth()/15.16f);
	private final int padding = Math.round(getWidth()/144);
	private final int card_view_width = Math.round(getWidth()/8.136f);
	private final int card_view_height = Math.round(getHeight()/3.469f);
	
	private Player player1;
	private Player player2;
	
	CardGraphicHand card;
	private Field field1;
	private Field field2;
	ArrayList<Card> hand;
	private ArrayList<ElementGraphic> elements;
	private SelectionGraphicElement selectionGraphicElement;
	public Yugioh(Player player1, Player player2) {
//		super((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		super(900,650);
		
//		Card c = new MonsterEffectCard();
//		card = new CardGraphicHand(c, padding + 460,padding + 700,card_view_width/2, card_view_height/2);
		this.player1 = player1;
		this.player2 = player2;
		
		field1 = player1.getField();
		field2 = player2.getField();
		player1.firstDraw();
		
		this.elements = new ArrayList<ElementGraphic>();
		
		hand = (ArrayList<Card>) player1.getField().getHand().getCardsList();
		createCards(hand, padding + Math.round(getWidth()/3.13f),Math.round(getHeight() -  card_view_height*2/5), card_view_width/2, card_view_height/2, card_dis_x);
		selectionGraphicElement = new SelectionGraphicElement(54, 61, 302,5,
				434,155,369,221,295,299 + 61,299 + 61 + 121);
//		selectionGraphicElement.setColor(Color.RED);
		
		ButtonGraphic draw = new ButtonGraphic("DRAW",getWidth() - 130,60 + 100,100, 50);
		ButtonGraphic M1 = new ButtonGraphic("M1",getWidth() - 130,60 + 160,100, 50);
		ButtonGraphic BP = new ButtonGraphic("BP",getWidth() - 130,60 + 220,100, 50);
		ButtonGraphic M2 = new ButtonGraphic("M2",getWidth() - 130,60 + 280,100, 50);
		ButtonGraphic EP = new ButtonGraphic("EP",getWidth() - 130,60 + 340,100, 50);
		
		elements.add(selectionGraphicElement);
		elements.add(draw);
		elements.add(M1);
		elements.add(BP);
		elements.add(M2);
		elements.add(EP);
		
		
	}
	
	@Override
	public void key(String tecla) {
		if(tecla.equals(" ")){
			player1.draw();
//			scorenumber.setScore(0);
//			proxCena().executa();
		}
	}

	@Override
	public void mouse(MouseEvent mouseEvent) {
//		if(mouseEvent.getButton()== MouseEvent.BUTTON1)
//		{
//		
//			if(mouseEvent.is) {
//				System.out.println("MOUSE");
			try {
				for(ElementGraphic e : elements)
					e.clickAction(mouseEvent);
//			else
//				System.out.println("FORA");
			}catch (Exception e) {
				e.printStackTrace();
			}
//			}
//		}
	}
	
	@Override
	public void move(MouseEvent mouseEvent) {
		try {
			for(ElementGraphic e : elements)
				e.hoverAction(mouseEvent);
//		else
//			System.out.println("FORA");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCards(ArrayList<Card> cards,int x,int y,int width,int height, int distance) {
		for(int i = 0;i<cards.size();i++) {
			card = new CardGraphicHand(cards.get(i), x + i*distance,y,width,height);
			if(!elements.contains(card))
				elements.add(card);
//			card.drawItself(screen);
		}
	}
	
	private void drawCards(Screen screen,ArrayList<ElementGraphic> elements2) {
		for(ElementGraphic e : elements2)
			e.drawItself(screen);
	}

	
	@Override
	public void draw(Screen screen) {		
		//		c, padding + 460,padding + 700,card_view_width/2, card_view_height/2
		
		
//		int padding = Math.round(getWidth()/144);
//		int card_view_width = Math.round(getWidth()/8.136f);
//		int card_view_height = Math.round(getHeight()/3.469f);
		screen.imageScaled("images/textures/background.jpg", 0, 0, getWidth(), getHeight(), 0,0, 0,1);
//		screen.imageScaledPerspective("images/textures/field2.png", 0, 0, getWidth()*2/3, getHeight()/2, 0,getWidth()/2 - getWidth()/3, getHeight()/4);
//		System.out.println("TAMANHO DA TELA: WIDTH: "+ getWidth() + "  HEIGHT: " + getHeight());
		screen.imageScaled("images/textures/field3.png", 0, 0, getWidth()*3/5, getHeight()*2/3, 0,getWidth()/2 - getWidth()*3/10 , getHeight()/2 - getHeight()/3,1);
		
		/**Magicas player 1 */

		
		int special_zone_x = 608;
		int special_zone_height = 59;
		int special_zone_width = 39;
		int deck_1_y = 473;
		//DECK 1
		screen.rectangle(special_zone_x,474, special_zone_width, special_zone_height, Color.RED,0.4f);
		//PENDULUM
		screen.rectangle(special_zone_x,404, special_zone_width, special_zone_height, Color.RED,0.4f);
		//GRAVE1
		screen.rectangle(special_zone_x,332, special_zone_width, special_zone_height, Color.RED,0.4f);
		//BAN2 
		screen.rectangle(special_zone_x,188, special_zone_width, special_zone_height, Color.RED,0.4f);
		//BAN2 
		screen.rectangle(special_zone_x,118, special_zone_width, special_zone_height, Color.RED,0.4f);
		//DECK2
		screen.rectangle(special_zone_x - 360,118, special_zone_width, special_zone_height, Color.RED,0.4f);
		
		
		//		screen.rectangle(299 + 60,434, 58, 64, Color.RED,0.4f);
//		//EXTRA ZONE1
//		screen.rectangle(299 + 61,295, 54, 61, Color.RED,0.4f);
//		//EXTRA ZONE2
//		screen.rectangle(299 + 61 + 121,295, 54, 61, Color.RED,0.4f);
		
//		screen.rectangle(299 + 120,434, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 179,434, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 239,434, 58, 66, Color.WHITE,0.4f);
//		
//		/**Monstros player 1 */
//		screen.rectangle(299,369, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 60,369, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 120,369, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 179,369, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 239,369, 58, 66, Color.WHITE,0.4f);
//		
//		/**Monstros player 2 */
//		screen.rectangle(299,218, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 60,218, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 120,218, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 179,218, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 239,218, 58, 66, Color.WHITE,0.4f);
//		/**Magias player 2 */
//		screen.rectangle(299,153, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 60,153, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 120,153, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 179,153, 58, 66, Color.WHITE,0.4f);
//		screen.rectangle(299 + 239,153, 58, 66, Color.WHITE,0.4f);
		
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width, card_view_height,0, padding,padding);
//		screen.text("EXODIA O CAPIROTEX", 10,290, 20, Color.WHITE);
		
		
		//		for(int i=0;i<5;i++) {
//			
//			Card c = new MonsterEffectCard();
//			card = new CardGraphicField(c,Math.round(getWidth()/2.89f) + card_dis_x * i ,Math.round(getHeight()/2.94f), card_width ,card_height);
//			card.drawItself(screen);
//			
////			screen.imageScaled("images/cards/default.jpg", 0, 0,card_width ,card_height, 0,Math.round(getWidth()/2.89) + card_dis_x * i,Math.round(getHeight()/2.94));
//		}
		
		for(int i=0;i<5;i++) {
			screen.imageScaled("images/cards/facedown.png", 0, 0,card_width ,card_height, 0,Math.round(getWidth()/2.89) + card_dis_x * i,Math.round(getHeight()/4.15),1);
		}
//		for(int i=0;i<5;i++) {
//			screen.imageScaled("images/cards/facedown.png", 0, 0,card_width ,card_height, 0,Math.round(getWidth()/2.89) + card_dis_x * i,Math.round(getHeight()/1.7445));
//		}
//		for(int i=0;i<5;i++) {
//			screen.imageScaled("images/cards/facedown.png", 0, 0,card_width ,card_height, 0,Math.round(getWidth()/2.89) + card_dis_x * i,Math.round(getHeight()/1.4832));
//		}
//		Card c = new MonsterEffectCard();
//		card = new CardGraphicHand(c, padding + 460,padding + 700,card_view_width/2, card_view_height/2);
//		card.drawItself(screen);
		WindowGraphic w = new WindowGraphic(0, 0, getWidth()*2/9,getHeight());
		w.drawItself(screen);
//		WindowGraphic w2 = new WindowGraphic(750, 0, getWidth()/4,getHeight());
//		w2.drawItself(screen);
		screen.imageScaled(FilesConstants.CARDS_IMG_DIR + FilesConstants.DEFAULT_MONTER_CARD_IMAGE,0,0,178,250,0,10,45,1);
		selectionGraphicElement.drawItself(screen);
		drawCards(screen,elements);


		
//		draw.drawItself(screen);
//		M1.drawItself(screen);
//		BP.drawItself(screen);
//		M2.drawItself(screen);
//		EP.drawItself(screen);
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width/2, card_view_height/2,0, padding + 460,padding + 700);
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width/2, card_view_height/2,0, padding + 560,padding + 700);
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width/2, card_view_height/2,0, padding + 660,padding + 700);
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width/2, card_view_height/2,0, padding + 760,padding + 700);
//		screen.imageScaled("images/cards/default.jpg", 0, 0, card_view_width/2, card_view_height/2,0, padding + 860,padding + 700);
//		System.out.println("TAMANHO: " + (Math.round(getHeight()/1.7445) + 89));
	}	
	
	@Override
	public void tick(Set<String> teclas, double dt) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		Player player1 = new Player("teste1", null, new NormalDeck(50), new ExtraDeck());
		Player player2 = new Player("teste2", null, new NormalDeck(50), new ExtraDeck());
		new Engine(new Yugioh(player1,player2));
	}
	
}
