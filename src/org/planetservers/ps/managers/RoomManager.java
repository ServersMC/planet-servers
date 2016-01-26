package org.planetservers.ps.managers;

import java.awt.Graphics2D;
import org.planetservers.ps.enums.RoomEnum;
import org.planetservers.ps.types.Room;

public class RoomManager {

	private Room room = RoomEnum.SERVER.room;

	public void setRoom(Room room) {
		this.room = room;
		init();
	}
	
	public void create() {
		for (RoomEnum roomenum : RoomEnum.values()) {
			roomenum.room.create();
		}
	}
	
	public void init() {
		room.init();
	}
	
	public void update() {
		room.update();
	}
	
	public void draw(Graphics2D g) {
		room.draw(g);
	}
	
}
