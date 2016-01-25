package org.planetservers.ps.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.planetservers.ps.listeners.Keyboard;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel implements ActionListener {

	public JavaPanel() {
		super();
		setFocusable(true);
		requestFocus();
		
		// PreProcessing
		setPreferredSize(new Dimension(500, 500));
		addKeyListener(new Keyboard());
		Keyboard.setup();
		
		new Timer(1000/24, this).start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// PostProcessing
		Keyboard.reset();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(0xE0E0E0));
		g.fillRect(0, 0, getWidth(), getHeight());
		repaint();
	}
	
}
