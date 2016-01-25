package org.planetservers.ps.core;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("PlanetServers a001");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JavaPanel());
		f.setVisible(true);
		f.pack();
		f.setResizable(false);
		f.setLocationRelativeTo(null);
	}
	
}
