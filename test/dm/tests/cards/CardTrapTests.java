package dm.tests.cards;

import static org.junit.Assert.assertEquals;

import java.awt.Image;

import org.junit.Before;
import org.junit.Test;

import constants.CardType;
import constants.ColorPicture;
import constants.TrapType;
import dm.cards.DuelSpellCard;
import dm.cards.Effect;

public abstract class CardTrapTests extends CardTests<DuelSpellCard> {

	protected static String name = "Ultimate Offering";
	protected static String description = "The ultimate wizard in terms of attack and defense";
	protected static int type = TrapType.NORMAL;
	protected static int copies_number = 3;
	protected static Effect effect = null;
	protected static Image picture = null;
	
	protected static int cardType = CardType.TRAP;
	protected static int colorPicture = ColorPicture.TRAP;
	
	@Override
	@Before
	public void initCard(){
		setCard(new DuelSpellCard(name, description, picture, effect,type, copies_number));
	}
	
	@Test
	public void checkAttributesOnInitialCondition(){
		assertEquals(name,getCard().getName());
		assertEquals(description,getCard().getDescription());
		assertEquals(type,getCard().getType());
		assertEquals(cardType,getCard().getCardType());
		assertEquals(colorPicture,getCard().getColorPicture());
		assertEquals(copies_number,getCard().getCopiesNumber());
	}
		
}
