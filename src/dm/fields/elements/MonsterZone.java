package dm.fields.elements;

import constants.CardState;
import dm.cards.DuelCard;
import dm.cards.DuelMonsterCard;
import dm.exceptions.CardNotFoundException;
import dm.exceptions.ZoneOccupedException;

public class MonsterZone extends CardZone {

	public void setMonster(DuelMonsterCard monsterCard, int index) {
		putCard(monsterCard, index);	
		monsterCard.setState(CardState.FACE_DOWN);
	}

	public void setMonster(DuelMonsterCard monsterCard) {
		for(int i=0;i<5;i++)
			if(this.getCards()[i]==null)
			{
				this.getCards()[i] = monsterCard;	
				monsterCard.setState(CardState.FACE_DOWN);
				return;
			}
		throw new ZoneOccupedException("We can't add more cards in the field");
	}

	public void summonMonster(DuelMonsterCard monsterCard,int index) {
		putCard(monsterCard, index);	
		monsterCard.setState(CardState.FACE_UP_ATTACK);
	}
	
	public void summonMonster(DuelMonsterCard monsterCard) {
		for(int i=0;i<5;i++)
			if(this.getCards()[i]==null)
			{
				this.getCards()[i] = monsterCard;	
				monsterCard.setState(CardState.FACE_UP_ATTACK);
				return;
			}
		throw new ZoneOccupedException("We can't add more cards in the field");
	}

	public DuelCard remove(DuelMonsterCard monsterCard) {
		for(int i=0;i<ZONE_SIZE;i++)
			if(getCards()[i].equals(monsterCard))
			{
				remove(i);
				return getCards()[i];
			}
		throw new CardNotFoundException("Card was not found");
	}
	
}
