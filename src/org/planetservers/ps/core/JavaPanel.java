package org.planetservers.ps.core;

import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JavaPanel extends JPanel {

	public JavaPanel() {
		super();
		setFocusable(true);
		requestFocus();
		
		setPreferredSize(new Dimension(500, 500));
	}
	
}
