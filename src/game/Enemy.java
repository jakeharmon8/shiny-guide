package game;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public int x = 256, y = 256, size = 24;
	public boolean dead = false;
	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x-size/2, y-size/2, size, size);
	}
	
	public boolean collides(Bullet b) {
		if(Math.sqrt(Math.pow(x-b.x, 2)+ Math.pow(y-b.y, 2)) <= (size+b.size)/2) {
			return true;
		}
		return false;
	}
	
}
