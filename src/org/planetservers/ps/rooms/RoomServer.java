package org.planetservers.ps.rooms;

import java.awt.Graphics2D;
import org.planetservers.ps.enums.ImageEnum;
import org.planetservers.ps.types.Background;
import org.planetservers.ps.types.Room;

public class RoomServer extends Room {
	
	Background bg = new Background();
	
	@Override
	public void create() {
		bg.image = ImageEnum.BG_BACKGROUND.image;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
	}

}
