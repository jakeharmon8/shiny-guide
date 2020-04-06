package game;

import java.awt.Color;
import java.awt.Graphics;

public class EnemyBullet {
	public int x, y, size;
	
	public EnemyBullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.size = 6;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x-size/2, y-size/2, size, size);
	}
}
