package org.planetservers.ps.managers;

import java.awt.Graphics2D;
import org.planetservers.ps.enums.RoomEnum;
import org.planetservers.ps.types.Room;

public class RoomManager {

	private static Room room = RoomEnum.SERVER.room;

	public static void setRoom(Room room) {
		RoomManager.room = room;
		init();
	}
	
	public static void create() {
		for (RoomEnum roomenum : RoomEnum.values()) {
			roomenum.room.create();
		}
	}
	
	public static void init() {
		room.init();
	}
	
	public static void update() {
		room.update();
	}
	
	public static void draw(Graphics2D g) {
		room.draw(g);
	}
	
}
