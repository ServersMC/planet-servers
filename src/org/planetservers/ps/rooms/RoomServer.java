package org.planetservers.ps.rooms;

import java.awt.Graphics2D;
import org.planetservers.ps.core.Display;
import org.planetservers.ps.enums.ImageEnum;
import org.planetservers.ps.types.Background;
import org.planetservers.ps.types.Button;
import org.planetservers.ps.types.Room;

public class RoomServer extends Room {
	
	Background bg;
	Button test;
	
	@Override
	public void create() {
		bg = new Background(ImageEnum.BG_BACKGROUND.image);
		test = new Button("Test Message", // message
				Display.width / 2, // x
				Display.height / 2, // y
				Display.width / 2, // width
				Display.height / 10, // height
				new Thread()); // thread
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		test.update();
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		test.draw(g);
	}

}
