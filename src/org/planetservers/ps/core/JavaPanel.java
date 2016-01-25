package org.planetservers.ps.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.planetservers.ps.listeners.Keyboard;
import org.planetservers.ps.managers.RoomManager;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	private static final Integer width = 960;
	private static final Integer height = 540;
	
	private RoomManager rm = new RoomManager();
	public static BufferedImage image;
	
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
	public int getWidth() {
		return width * 2;
	}
	
	@Override
	public int getHeight() {
		return height * 2;
	}
	
	@Override
	public void paint(Graphics g) {
		image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		g2.setColor(new Color(0xE0E0E0));
		g2.fillRect(0, 0, getWidth(), getHeight());
		rm.draw(g2);
		g.drawImage(image, 0, 0, getWidth() / 2, getHeight() / 2, null);
		repaint();
	}
	
}
