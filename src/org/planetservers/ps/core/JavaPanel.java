package org.planetservers.ps.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.planetservers.ps.listeners.Keyboard;
import org.planetservers.ps.managers.RoomManager;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	public static final Integer width = 960;
	public static final Integer height = 540;
	
	private RoomManager rm = new RoomManager();
	
	public JavaPanel() {
		super();
		setFocusable(true);
		requestFocus();
		
		setPreferredSize(new Dimension(width / 2, height / 2));
		addKeyListener(new Keyboard());
		Keyboard.setup();
		rm.create();
		rm.init();
		
		new Timer(1000/24, this).start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		rm.update();
		Keyboard.reset();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.transform(AffineTransform.getScaleInstance(0.5, 0.5));
		g2.setColor(new Color(0xE0E0E0));
		g2.fillRect(0, 0, getWidth() * 2, getHeight() * 2);
		rm.draw(g2);
		repaint();
	}
	
}
