package org.planetservers.ps.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Mouse implements MouseListener, MouseMotionListener {

	private static Point point = new Point(0, 0);
	private static ArrayList<Boolean> keys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> pkeys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> rkeys = new ArrayList<Boolean>();

	public static void setup() {
		for (int i = 0; i < MouseEvent.BUTTON3; i++) {
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
	
}
