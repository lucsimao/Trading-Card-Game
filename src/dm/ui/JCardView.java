/** 
* @author Sim�o 
* @version 0.1 - 29 de jun de 2017
* 
*/
package dm.ui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dm.constants.FilesConstants;

public class JCardView extends JLabel {

	private static final long serialVersionUID = 1L;

	private Image cardImage;
	
	private int width;
	private int height;
	
	public JCardView(File file,int width,int height){

		this.width = width;
		this.height = height;
		
		try {
			cardImage = scaleImage(ImageIO.read(new File(FilesConstants.CARDS_IMG_DIR + FilesConstants.FACE_DOWN_CARD)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setIcon(new ImageIcon(cardImage));
	}
	
	public void setIcon(Image image) {
		cardImage = scaleImage(image);
		setIcon(new ImageIcon(cardImage));
	}
	
	public Image scaleImage(Image image){
		
		image = image.getScaledInstance(width,height, Image.SCALE_DEFAULT);
		return image;
		
	}
	
}
