package org.macunaima.gui.ui;

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
	private File file;

	public void setImageFile(File file) {
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(file);
			this.file = file;
			setIcon(new ImageIcon(myPicture));
		} catch (IOException e) {
			this.file = null;
		}
	}

	public File getImageFile() {
		return this.file;
	}

}
