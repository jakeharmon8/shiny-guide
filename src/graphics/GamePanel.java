package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.Bullet;
import game.Enemy;
import game.EnemyBullet;
import game.HealthBar;
import game.Player;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private int S_WIDTH = 512;
	private int S_HEIGHT = 512;
	
	private Player player;
	private HealthBar healthbar;
	private LinkedList<Bullet> bullets = new LinkedList();
	private LinkedList<Enemy> enemies = new LinkedList();
	private int time = 0;
	private LinkedList<EnemyBullet> enemybullets = new LinkedList();
	
	private Random random = new Random();
	
	
			
	
	
	private Timer timer;
	
	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		player = new Player();
		healthbar = new HealthBar(player);

		timer = new Timer(50, this);
		timer.start();

		setFocusable(true);
		requestFocus();
		
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		// clear screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
		
		player.draw(g);
		healthbar.draw(g);
		
		for(Bullet b : bullets) {
			b.draw(g);
			
		}
		for(Enemy b : enemies) {
			b.draw(g);
		}
		
		for(EnemyBullet b : enemybullets) {
			b.draw(g);
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			//player.y = player.y - 16;
			break;
		case KeyEvent.VK_A:
			player.movingLeft = true;
			player.movingRight = false;
			break;
		case KeyEvent.VK_S:
			//player.y = player.y + 16;
			break;
		case KeyEvent.VK_D:
			player.movingLeft = false;
			player.movingRight = true;
			break;
		case KeyEvent.VK_SPACE:
			Bullet b = new Bullet(player.x, player.y);
			bullets.add(b);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			player.movingLeft = false;
			break;
		case KeyEvent.VK_D:
			player.movingRight = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	// This is the game loop
	// It gets called by the Timer
	public void actionPerformed(ActionEvent e) {
		time++;
		player.update();
		
		for(Bullet b : bullets) {
			b.y -= 4;
		}
		
		if(random.nextInt(70) == 69) {
			Enemy b = new Enemy(random.nextInt(450)+32, 100);
			enemies.add(b);
		}
		if(enemies.size() > 0) {
			if(random.nextInt(50) == 25) {
				EnemyBullet b = new EnemyBullet(enemies.get(random.nextInt(enemies.size())).x, 100);
				enemybullets.add(b);
			}
			
		}
		
		
		for(EnemyBullet b : enemybullets) {
			b.y += 4;
		}
		
		for(Enemy b : enemies) {
			b.x += (Math.cos(time/2)*5);
		}
		
		for(Enemy enemy : enemies) {
			for(Bullet bullet : bullets) {
				if(enemy.collides(bullet)) {
					enemy.dead = true;
				}
			}
				
		}
		
		for(EnemyBullet b : enemybullets) {
			if(player.collides(b)) {
				player.health--;
				b.dead = true;
			}
			if(player.health <= 0) {
				System.exit(0);
			}
		}
			
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).dead) {
				enemies.remove(enemies.get(i));
				i--;
			}
		}
		
		for(int i = 0; i < enemybullets.size(); i++) {
			if(enemybullets.get(i).dead) {
				enemybullets.remove(enemybullets.get(i));
				i--;
			}
		}

		
		
		repaint();
	}
}
