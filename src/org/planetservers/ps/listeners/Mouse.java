package org.planetservers.ps.listeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javafx.scene.input.MouseButton;

public class Mouse implements MouseListener, MouseMotionListener {

	private static Point point = new Point(0, 0);
	private static ArrayList<Boolean> keys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> pkeys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> rkeys = new ArrayList<Boolean>();

	public static void setup() {
		for (int i = 0; i < MouseButton.values().length; i++) {
			keys.add(false);
			pkeys.add(false);
			rkeys.add(false);
		}
	}
	
	public static void reset() {
		for (int i = 0; i < keys.size(); i++) {
			pkeys.set(i, false);
			rkeys.set(i, false);
		}
	}
	
	public static Boolean isDirect(Integer button) {
		return keys.get(button);
	}
	
	public static Boolean isPressed(Integer button) {
		return pkeys.get(button);
	}
	
	public static Boolean isReleased(Integer button) {
		return rkeys.get(button);
	}
	
	public static Point getPoint() {
		return point;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		point = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		point = e.getPoint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		keys.set(e.getButton(), true);
		pkeys.set(e.getButton(), true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		keys.set(e.getButton(), false);
		rkeys.set(e.getButton(), true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}

	public static void debug(Graphics2D g) {
		g.setColor(new Color(0x0));
		g.setFont(g.getFont().deriveFont(15f).deriveFont(Font.BOLD));
		g.drawString("X: " + point.getX(), 5, 25);
		g.drawString("Y: " + point.getY(), 5, 45);
		g.fillRect((int) Mouse.getPoint().getX() - 5, (int) Mouse.getPoint().getY() - 5, 10, 10);
	}
	
}
