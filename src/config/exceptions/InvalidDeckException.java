/** 
* @author Sim�o 
* @version 0.1 - 6 de jul de 2017
* 
*/
package config.exceptions;

public class InvalidDeckException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDeckException(String message){
		super(message);
	}
	
}
