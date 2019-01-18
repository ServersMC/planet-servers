package org.planetservers.ps.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.planetservers.ps.listeners.Keyboard;
import org.planetservers.ps.listeners.Mouse;
import org.planetservers.ps.managers.RoomManager;

@SuppressWarnings("serial")
public class Display extends JPanel implements ActionListener {

	public static Integer width = 480;
	public static Integer height = 270;
	
	BufferedImage image;
	Keyboard keyboard = new Keyboard();
	Mouse mouse = new Mouse();
	
	public Display() {
		setFocusable(true);
		requestFocus();
		
		setPreferredSize(new Dimension(width, height));
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		Keyboard.setup();
		Mouse.setup();
		RoomManager.create();
		RoomManager.init();
		
		new Timer(1000/24, this).start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		RoomManager.update();
		Keyboard.reset();
		Mouse.reset();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		g2.setFont(g2.getFont().deriveFont(30F));
		setRenderingHints(g1);
		setRenderingHints(g2);
		g2.setColor(new Color(0xE0E0E0));
		g2.fillRect(0, 0, width, height);
		RoomManager.draw(g2);
		g1.drawImage(image, 0, 0, width, height, null);
		repaint();
	}
	
	public void setRenderingHints(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}
	
}
