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
	public int health = 5;
	
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
	
	public boolean collides(EnemyBullet b) {
		if(Math.sqrt(Math.pow(x-b.x, 2)+ Math.pow(y-b.y, 2)) <= (size+b.size)/2) {
			return true;
		}
		return false;
	}

}
