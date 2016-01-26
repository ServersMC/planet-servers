package org.planetservers.ps.rooms;

import java.awt.Graphics2D;
import org.planetservers.ps.core.Display;
import org.planetservers.ps.enums.ImageEnum;
import org.planetservers.ps.types.Room;

public class RoomMain extends Room {
	
	@Override
	public void create() {
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(ImageEnum.BG_BACKGROUND.image, 0, 0, Display.width, Display.height, null);
	}

}
