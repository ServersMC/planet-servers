package org.planetservers.ps.types;

import java.awt.Graphics2D;

public abstract class Room {

	public abstract void create();
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
}
