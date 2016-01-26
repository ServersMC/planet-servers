package org.planetservers.ps.types;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import org.planetservers.ps.core.Display;

public class Background {

	public BufferedImage image;

	public Background(BufferedImage image) {
		this.image = image;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(image, 0, 0, Display.width, Display.height, null);
	}

}
