/** 
* @author Sim�o 
* @version 0.1 - 30 de abr de 2017
* Esta classe serve para salvar as cartas em um arquivo. Ela pode ser substituida por 
* outro DAO se necess�rio.
*/
package dm.files;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dm.cards.abstracts.Card;
import dm.constants.FilesConstants;

public class CardDAO {

	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;

	/**
	 * Salva a carta no arquivo dado, sobrescrevendo-o
	 * 
	 * @param file
	 *            o caminho do arquivo
	 * @param card
	 *            a carta para ser salva
	 * @throws CardExistsException 
	 * @throws ClassNotFoundException 
	 **/
	public void saveToFile(String file, Card card) throws FileNotFoundException, IOException, ClassNotFoundException, CardExistsException {
		saveToFile(file, false, card);
	}

	/**
	 * Salva a carta no arquivo padr�o, sobrescrevendo-o
	 ** 
	 * @param card
	 *            a carta para ser salva
	 * @throws CardExistsException 
	 * @throws ClassNotFoundException 
	 **/
	public void saveToFile(Card card) throws FileNotFoundException, IOException, ClassNotFoundException, CardExistsException {
		saveToFile(getFile().getPath(), card);
	}

	/**
	 * Salva a carta no arquivo padr�o, sem sobrescrever
	 ** 
	 * @param card
	 *            a carta para ser salva
	 * @throws CardExistsException 
	 * @throws ClassNotFoundException 
	 **/
	public void saveToEndFile(Card card) throws FileNotFoundException, IOException, ClassNotFoundException, CardExistsException {
		saveToEndFile(getFile().getPath(), card);
	}

	/**
	 * Salva a carta no arquivo dado, sem sobrescrever
	 * 
	 * @param file
	 *            o caminho do arquivo
	 * @param card
	 *            a carta para ser salva
	 * @throws CardExistsException 
	 * @throws ClassNotFoundException 
	 **/
	public void saveToEndFile(String file, Card card) throws FileNotFoundException, IOException, ClassNotFoundException, CardExistsException {
		saveToFile(file, true, card);
	}

	/**
	 * L� a carta de um arquivo.
	 * 
	 * @param file
	 *            o caminho do arquivo
	 * @return a carta que ele leu
	 **/

	public Card readFile(String file) throws IOException, FileNotFoundException, ClassNotFoundException {
		Card card;
		fileInputStream = new FileInputStream(file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		card = (Card) objectInputStream.readObject();
		fileInputStream.close();
		return card;
	}

	/**
	 * L� todas as cartas do arquivo
	 * 
	 * @param file
	 *            o caminho do arquivo
	 * @return um array com as cartas
	 */
	public List<Card> readAllFile(String file) throws IOException, FileNotFoundException, ClassNotFoundException {
		Card card;
		List<Card> list = new ArrayList<>();
		fileInputStream = new FileInputStream(file);
		while (true) {
			try {
				objectInputStream = new ObjectInputStream(fileInputStream);
				card = (Card) objectInputStream.readObject();
				list.add(card);
			} catch (EOFException e) {
				break;
			}
		}
		// objectInputStream.close();
		fileInputStream.close();
		return list;
	}

	public List<Card> readAllFile() throws FileNotFoundException, ClassNotFoundException, IOException {
		return readAllFile(getFile().getPath());
	}

	private File getFile() throws IOException {
		String filename = FilesConstants.CARDS_DB + "/" + "cards" + FilesConstants.EXTENSION;
		File file = new File(filename);
		file.getParentFile().mkdirs();
		file.createNewFile();
		return file;
	}

	public void deleteFile(String file, Card card) throws IOException, FileNotFoundException, ClassNotFoundException, CardExistsException {

		List<Card> cards = readAllFile(file);
		System.out.println(cards.contains(card));
		System.out.println(cards.size());
		cards.remove(card);
		System.out.println(cards.size());

		clearFile(file);
		for (Card c : cards) {
			saveToEndFile(file, c);
		}
	}

	public boolean contains(Card card, String file) throws FileNotFoundException, ClassNotFoundException, IOException {
		List<Card> cards = readAllFile(file);
		return cards.contains(card);
	}

	private void saveToFile(String file, boolean append, Card card) throws IOException, FileNotFoundException, CardExistsException, ClassNotFoundException {
		if(readAllFile(file).contains(card))
			throw new CardExistsException("This card already exists in our database");
		
		fileOutputStream = new FileOutputStream(file, append);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(card);
		objectOutputStream.flush();
		fileOutputStream.close();
	}

	public void clearFile(String file) throws IOException, FileNotFoundException {
		fileOutputStream = new FileOutputStream(file, false);
		fileOutputStream.close();
	}

	public void saveCard(Card card)
			throws FileNotFoundException, ClassNotFoundException, IOException, CardExistsException {
		if (contains(card, getFile().getPath()))
			throw new CardExistsException("This card already exists on our database");
		saveToEndFile(card);

	}

	public String getId() {
		List<Card> cards = new ArrayList<>(0);
		try {
			cards = readAllFile(getFile().getPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "" + cards.size();
	}

	public void clearFile() throws FileNotFoundException, IOException {
		clearFile(getFile().getPath());
	}

}
