package dm.tests.fields;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dm.cards.Effect;
import dm.cards.MonsterEffectCard;
import dm.cards.MonsterFusionCard;
import dm.cards.MonsterNormalCard;
import dm.cards.abstracts.MonsterCard;
import dm.constants.MonsterAttribute;
import dm.constants.MonsterType;
import dm.fields.Field;
import dm.fields.elements.decks.ExtraDeck;
import dm.fields.elements.decks.NormalDeck;

public class FieldMonsterTests {

	private Field field;

	private MonsterCard monsterCard;
	private MonsterFusionCard monsterFusionCard;
	private MonsterCard monsterEffectCard;
	// private int deckSize;
	// private int handSize;

	private int monstersSize;

	@Before
	public void initCards() {
		monsterCard = new MonsterNormalCard("Dark Magician", "The ultimate wizard in terms of attack and defense.",
				null, MonsterType.SPELLCASTER, MonsterAttribute.DARK, 2500, 2100, 3);
		monsterFusionCard = new MonsterFusionCard("Gaia, The Dragon Champion", "The gaia dragon", null,
				MonsterType.WARRIOR, MonsterAttribute.EARTH, 2600, 2100, 0, null, 3);
		monsterEffectCard = new MonsterEffectCard("Penguin Soldier", "[FLIP] return one card to your hand", null,
				MonsterType.AQUA, MonsterAttribute.WATER, 500, 300, new Effect(), 3);
		field = new Field(new NormalDeck(50),new ExtraDeck(10));
		// deckSize = field.countDeckCards();
		// handSize = field.countHandCards();
		monstersSize = field.countMonsters();
	}

	@Test
	public void summonMonster() {
		field.summonMonster(monsterCard);
		assertEquals(monstersSize + 1, field.countMonsters());
		field.summonMonster(monsterCard);
		assertEquals(monstersSize + 2, field.countMonsters());
	}

	@Test
	public void sendToGraveyardMonster() {
		setCardsOnMonsterField();
		int zoneSize = field.countMonsters();
		int graveSize = field.countGraveCards();

		field.sendToGraveyard(monsterCard);
		field.sendToGraveyard(monsterFusionCard);

		assertEquals(zoneSize - 2, field.countMonsters());
		assertEquals(graveSize + 2, field.countGraveCards());
	}

	private void setCardsOnMonsterField() {
		try {
			field.setCard(monsterCard);
			field.setCard(monsterFusionCard);
			field.setCard(monsterEffectCard);
			field.setCard(monsterCard);
			field.setCard(monsterFusionCard);
			assertEquals(5, field.countMonsters());
		} catch (Exception e) {
			System.out.println("N�o consegui setar os monstros");
		}

	}

	@Test
	public void returnToHandMonster() {
		setCardsOnMonsterField();

		int zoneSize = field.countMonsters();
		int handSize = field.countHandCards();
		int extraDeckSize = field.countExtraDeckCards();
		field.returnToHand(monsterCard);
		field.returnToHand(monsterEffectCard);
		field.returnToHand(monsterFusionCard);

		assertEquals(zoneSize - 3, field.countMonsters());
		assertEquals(extraDeckSize + 1, field.countExtraDeckCards());
		assertEquals(handSize + 2, field.countHandCards());
	}

	@Test
	public void setMonster() {
		System.out.println(monstersSize);
		field.setCard(monsterCard);
		assertEquals(monstersSize + 1, field.countMonsters());
		// field.setCard(monsterCard);
		// assertEquals(monstersSize+2,field.countMonsters());
	}

	@Test
	public void returnToDeckMonster() {
		setCardsOnMonsterField();
		int zoneSize = field.countMonsters();
		int deckSize = field.countDeckCards();
		int extraDeckSize = field.countExtraDeckCards();
		
//		System.out.println("Field Size: " + field.countMonsters());
		
		field.returnToDeck(monsterCard);
		field.returnToDeck(monsterEffectCard);
		field.returnToDeck(monsterFusionCard);
		assertEquals(zoneSize - 3, field.countMonsters());
		assertEquals(deckSize + 2, field.countDeckCards());
		assertEquals(extraDeckSize + 1, field.countExtraDeckCards());
	}

	@Test
	public void removeFromPlayMonster() {
		setCardsOnMonsterField();
		int zoneSize = field.countMonsters();
		int remFPlaySize = field.countRemovedFromPlayCards();

		field.removeFromPlay(monsterCard);
		field.removeFromPlay(monsterFusionCard);
		field.removeFromPlay(monsterEffectCard);

		assertEquals(zoneSize - 3, field.countMonsters());
		assertEquals(remFPlaySize + 3, field.countRemovedFromPlayCards());
	}

}