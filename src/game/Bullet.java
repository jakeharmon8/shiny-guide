package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	public int x, y, size;
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = 6;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-size/2, y-size/2, size, size);
	}
}
