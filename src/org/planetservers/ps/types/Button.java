package org.planetservers.ps.types;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Button {

	public String text;
	public Integer width, height, x, y;
	public Thread thread;
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g) {
		g.setColor(new Color(0x0));
		g.fillRect(x - (width / 2), y - (height / 2), width, height);
		g.setColor(new Color(0xFFFFFF));
		FontMetrics fm = g.getFontMetrics(g.getFont());
		g.drawString(text, x - (fm.stringWidth(text) / 2), y + (fm.getHeight() / 4));
	}
	
}
