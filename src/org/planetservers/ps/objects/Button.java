package org.planetservers.ps.objects;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.planetservers.ps.listeners.Mouse;

public class Button {

	private Color BG_NORM = new Color(0x0);
	private Color BG_HOVER = new Color(0x99000000, true);
	private Color BG_COLOR = BG_NORM;
	
	private Color TXT_NORM = new Color(0xFFFFFF);
	private Color TXT_HOVER = new Color(0x99FFFFFF, true);
	private Color TXT_COLOR = TXT_NORM;
	
	public String text;
	public Integer x, y, width, height;
	public Thread thread;
	public Rectangle bounds;
	
	public Button(String text, Integer x, Integer y, Integer width, Integer height, Thread thread) {
		this.text = text;
		this.x = x - (width / 2);
		this.y = y - (height / 2);
		this.width = width;
		this.height = height;
		this.thread = thread;
		bounds = new Rectangle(this.x, this.y, width, height);
	}
	
	public void update() {
		if (bounds.contains(Mouse.getPoint())) {
			BG_COLOR = BG_HOVER;
			TXT_COLOR = TXT_HOVER;
			
			if (Mouse.isPressed(1)) {
				thread.run();
			}
		}
		else {
			BG_COLOR = BG_NORM;
			TXT_COLOR = TXT_NORM;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(BG_COLOR);
		g.fillRect(x, y, width, height);
		g.setColor(TXT_COLOR);
		g.setFont(g.getFont().deriveFont(15f));
		FontMetrics fm = g.getFontMetrics(g.getFont());
		g.drawString(text, x - (fm.stringWidth(text) / 2) + (width / 2), y + (fm.getHeight() / 4) + (height / 2));
	}
	
}
