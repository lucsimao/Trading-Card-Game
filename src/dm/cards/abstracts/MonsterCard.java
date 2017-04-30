package dm.cards.abstracts;

import java.awt.Image;

import dm.cards.Effect;
import dm.constants.CardType;

/**
 * Classe Monstro
 * Classe abstrata para tratar os monstros do jogo.
 * Eles possuem n�veis, atributos e tipo.
 * Eles possuem ataque, defesa originais e correntes.
 * O ataque e defesa correntes podem ser alterados por cartas de equipamento.
 * Eles tamb�m podem voltar o ataque e defesa para o original. 
 *@author Sim�o */

public abstract class MonsterCard extends Card {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1160252849178277811L;
	
	private int type;
	private int atribute;
	private int originalAttack;
	private int originalDefense;
	private int currentAttack;
	private int currentDefense;

	public MonsterCard(String name, String description, int colorPicture, Image picture, int type, int atribute,
			int originalAttack, int originalDeffense, Effect effect, int copies_number) {
		super(name, description, CardType.MONSTER, colorPicture, picture, effect, copies_number);
		this.type = type;
		this.atribute = atribute;
		this.originalAttack = originalAttack;
		this.originalDefense = originalDeffense;
		this.currentAttack = originalAttack;
		this.currentDefense = originalDeffense;

	}

	public void increaseAttack(int increment) {
		this.currentAttack += increment;
		if (this.currentAttack > 9999)
			this.currentAttack = 9999;
	}

	public void increaseDefense(int increment) {
		this.currentDefense += increment;
		if (this.currentDefense > 9999)
			this.currentDefense = 9999;
	}

	public void decreaseAttack(int increment) {
		this.currentAttack -= increment;
		if (this.currentAttack < 0)
			this.currentAttack = 0;
	}

	public void decreaseDefense(int increment) {
		this.currentDefense -= increment;
		if (this.currentDefense < 0)
			this.currentDefense = 0;
	}

	public void turnBackOriginalAttack() {
		this.currentAttack = this.originalAttack;
	}

	public void turnBackOriginalDefense() {
		this.currentDefense = originalDefense;
	}

	// Getters and Setters
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAtribute() {
		return atribute;
	}

	public void setAtribute(int atribute) {
		this.atribute = atribute;
	}

	public int getCurrentAttack() {
		return currentAttack;
	}

	public void setCurrentAttack(int currentAttack) {
		this.currentAttack = currentAttack;
	}

	public int getCurrentDefense() {
		return currentDefense;
	}

	public void setCurrentDefense(int currentDeffense) {
		this.currentDefense = currentDeffense;
	}

	public int getOriginalAttack() {
		return originalAttack;
	}

	public int getOriginalDefense() {
		return originalDefense;
	}

}
