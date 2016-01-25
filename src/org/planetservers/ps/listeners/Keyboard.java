package org.planetservers.ps.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keyboard implements KeyListener {

	private static ArrayList<Boolean> keys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> pkeys = new ArrayList<Boolean>();
	private static ArrayList<Boolean> rkeys = new ArrayList<Boolean>();
	
	public static void setup() {
		for (int i = 0; i < KeyEvent.KEY_LAST; i++) {
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
	
	public static Boolean isDirect(Integer keycode) {
		return keys.get(keycode);
	}
	
	public static Boolean isPressed(Integer keycode) {
		return pkeys.get(keycode);
	}
	
	public static Boolean isReleased(Integer keycode) {
		return rkeys.get(keycode);
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		keys.set(event.getKeyCode(), true);
		pkeys.set(event.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent event) {
		keys.set(event.getKeyCode(), false);
		rkeys.set(event.getKeyCode(), true);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
