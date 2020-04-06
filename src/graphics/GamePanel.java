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
import game.Player;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private int S_WIDTH = 512;
	private int S_HEIGHT = 512;
	
	private Player player;
	private LinkedList<Bullet> bullets = new LinkedList();
	private LinkedList<Enemy> enemies = new LinkedList();
	private int time = 0;
	
	private Random random = new Random();
	
			
	
	
	private Timer timer;
	
	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		player = new Player();

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
		
		for(Bullet b : bullets) {
			b.draw(g);
			
		}
		for(Enemy b : enemies) {
			b.draw(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.y = player.y - 16;
			break;
		case KeyEvent.VK_A:
			player.x = player.x - 16;
			break;
		case KeyEvent.VK_S:
			player.y = player.y + 16;
			break;
		case KeyEvent.VK_D:
			player.x = player.x + 16;
			break;
		case KeyEvent.VK_SPACE:
			Bullet b = new Bullet(player.x, player.y);
			bullets.add(b);
			break;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	// This is the game loop
	// It gets called by the Timer
	public void actionPerformed(ActionEvent e) {
		time++;
		for(Bullet b : bullets) {
			b.y -= 4;
		}
		
		if(random.nextInt(70) == 69) {
			Enemy b = new Enemy(random.nextInt(450)+32, 100);
			enemies.add(b);
		}
		for(Enemy b : enemies) {
			b.x += (Math.cos(time/2)*5);
		}
		
		
		
		
		repaint();
	}
}
