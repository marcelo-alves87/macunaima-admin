package org.macunaima.gui.ui;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DIMENSION = 128;
	private File file;

	public void setImageFile(File file) {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(file);
			int type = myPicture.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : myPicture.getType();
			BufferedImage resizeImageJpg = resizeImage(myPicture, type);
			File outputfile = new File("image.jpg");
			ImageIO.write(resizeImageJpg, "jpg", outputfile);
			myPicture = ImageIO.read(outputfile);
			this.file = outputfile;
			setIcon(new ImageIcon(myPicture));
		} catch (IOException e) {
			this.file = null;
		}
	}

	private BufferedImage resizeImage(BufferedImage myPicture, int type) {
		BufferedImage resizedImage = null;
		if (myPicture.getWidth() > DIMENSION && myPicture.getHeight() > DIMENSION) {
			resizedImage = new BufferedImage(myPicture.getWidth() * DIMENSION / myPicture.getWidth(),
					myPicture.getHeight() * DIMENSION / myPicture.getHeight(), type);
		} else if (myPicture.getWidth() > DIMENSION) {
			resizedImage = new BufferedImage(myPicture.getWidth() * DIMENSION / myPicture.getWidth(),
					myPicture.getHeight(), type);
		} else if (myPicture.getHeight() > DIMENSION) {
			resizedImage = new BufferedImage(myPicture.getWidth(),
					myPicture.getHeight() * DIMENSION / myPicture.getHeight(), type);
		} else {
			resizedImage = new BufferedImage(myPicture.getWidth(), myPicture.getHeight(), type);
		}

		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(myPicture, 0, 0, resizedImage.getWidth(), resizedImage.getHeight(), null);
		g.dispose();

		return resizedImage;
	}

	public File getImageFile() {
		return this.file;
	}

}
