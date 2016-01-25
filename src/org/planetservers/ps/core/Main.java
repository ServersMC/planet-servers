package org.planetservers.ps.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("PlanetServers a" + (getBuild() + 1));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JavaPanel());
		f.setVisible(true);
		f.pack();
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		updateBuild();
	}
	
	private static Integer getBuild() {
		Integer output = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("alpha.build")));
			output = Integer.parseInt(reader.readLine());
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	private static void updateBuild() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("alpha.build")));
			int build = Integer.parseInt(reader.readLine());
			reader.close();
			PrintWriter writer = new PrintWriter(new File("alpha.build"));
			writer.println(build + 1);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
