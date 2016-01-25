package org.planetservers.ps.enums;

import org.planetservers.ps.rooms.RoomMain;
import org.planetservers.ps.types.Room;

public enum RoomEnum {

	MAIN(new RoomMain());
	
	public Room room;
	public Integer id;
	
	private RoomEnum(Room room) {
		this.room = room;
		id = ordinal();
	}
	
}
