/**
 * 
 */
package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author jacob
 *
 */
public class Player {
	public int x = 256, y = 400, size = 32, speed = 12;
	public boolean movingLeft = false, movingRight = false;
	
	public void update() {
		if(movingLeft) {
			x -= speed;
		}
		if(movingRight) {
			x += speed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x-size/2, y-size/2, size, size);
	}
}
