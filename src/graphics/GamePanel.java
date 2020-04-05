package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import game.Player;

public class GamePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	private int S_WIDTH = 512;
	private int S_HEIGHT = 512;
	
	private Player player;
	
	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		player = new Player();
		
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
			break;
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}
