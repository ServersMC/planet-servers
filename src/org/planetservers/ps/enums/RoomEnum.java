package org.planetservers.ps.enums;

import org.planetservers.ps.rooms.RoomServer;
import org.planetservers.ps.types.Room;

public enum RoomEnum {

	SERVER(new RoomServer());
	
	public Room room;
	public Integer id;
	
	private RoomEnum(Room room) {
		this.room = room;
		id = ordinal();
	}
	
}
