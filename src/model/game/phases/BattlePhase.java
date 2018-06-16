package model.game.phases;

import config.exceptions.MonsterCannotAttackException;
import model.cards.abstracts.MonsterCard;
import model.game.Player;

public class BattlePhase extends Phase {

	
	
	public BattlePhase(Player player) {
		super(player);
	}
		
	public void attack(MonsterCard attacking, Player player_attacked, MonsterCard attacked) {
		if(canAttack(attacking)) {
			getPlayer().attack(attacking, player_attacked, attacked);
			attacking.incrementAttacksCount();
		}else {
			if(attacking.getAttacksCount()>0)
				throw new MonsterCannotAttackException("Monstro j� atacou essa rodada");
			throw new MonsterCannotAttackException("Monstro n�o pode atacar");
		}
	}

	private boolean canAttack(MonsterCard attacking) {
		return attacking.getAttacksCount()<attacking.getMaxAttacks();
	}
	
}
