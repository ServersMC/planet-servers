package org.planetservers.ps.rooms;

import java.awt.Graphics2D;
import org.planetservers.ps.core.Display;
import org.planetservers.ps.enums.ImageEnum;
import org.planetservers.ps.listeners.Mouse;
import org.planetservers.ps.objects.Button;
import org.planetservers.ps.types.Background;
import org.planetservers.ps.types.Room;

public class RoomServer extends Room {
	
	private Background bg;
	private Button test;
	private Button test2;
	
	private int button_num = 2;
	private int width = Display.width / 2;
	private int height = Display.height / 10;
	private int x = Display.width / 2;
	private int y = Display.height / 2;
	
	@Override
	public void create() {
		bg = new Background(ImageEnum.BG_BACKGROUND.image);
		
		y += ((height * button_num) + (button_num * 10)) / 4;
		
		test = new Button("Test Message 1", // message
				x, // x
				y - d(), // y
				width, // width
				height, // height
				new Thread(() -> {
			System.out.println("test");
		})); // thread
		test2 = new Button("Test Message 2", // message
				x, // x
				y - d(), // y
				width, // width
				height, // height
				new Thread(() -> {
			System.out.println("test");
		})); // thread
	}
	
	public int d() {
		return (height * --button_num) + (10 * button_num + 1);
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		test.update();
		test2.update();
	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		test.draw(g);
		test2.draw(g);
		Mouse.debug(g);
	}

}
