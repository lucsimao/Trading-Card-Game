package dm.cards;

/** @author Sim�o */
public interface NormalDeckCard extends Cloneable{
	int getCopiesNumber();
	public Object clone() throws CloneNotSupportedException ;
}
