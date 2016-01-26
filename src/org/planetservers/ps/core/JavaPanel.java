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
import org.planetservers.ps.managers.RoomManager;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	public static Integer width = 960;
	public static Integer height = 540;
	
	private RoomManager rm = new RoomManager();
	private BufferedImage image;
	
	public JavaPanel() {
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
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0xE0E0E0));
		g2.fillRect(0, 0, width * 2, height * 2);
		rm.draw(g2);
		g.drawImage(image, 0, 0, width / 2, height / 2, null);
		repaint();
	}
	
}
