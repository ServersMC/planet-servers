package org.planetservers.ps.rooms;

import java.awt.Graphics2D;
import org.planetservers.ps.core.Display;
import org.planetservers.ps.enums.ImageEnum;
import org.planetservers.ps.types.Background;
import org.planetservers.ps.types.Button;
import org.planetservers.ps.types.Room;

public class RoomServer extends Room {
	
	Background bg = new Background();
	Button test = new Button();
	
	@Override
	public void create() {
		bg.image = ImageEnum.BG_BACKGROUND.image;
		test.text = "TEST MESSAGE";
		test.x = Display.width / 2;
		test.y = Display.height / 2;
		test.width = Display.width / 2;
		test.height = Display.height / 10;
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
