package org.planetservers.ps.enums;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public enum ImageEnum {

	BG_BACKGROUND("/bg/background.png");

	public BufferedImage image;
	
	private ImageEnum(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
