package game;

import java.awt.Color;
import java.awt.Graphics;

public class HealthBar {
	public int x, y;
	public Player p;
	
	public HealthBar(Player p) {
		this.p = p;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(32, 480, p.health * 15, 32);
	}
}
