package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public int x = 256, y = 256, size = 24;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x-size/2, y-size/2, size, size);
	}
	
}
