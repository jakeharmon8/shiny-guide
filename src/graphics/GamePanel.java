package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import transform.Rotator;

public class GamePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	public static int S_WIDTH = 512;
	public static int S_HEIGHT = 512;
	
	List<Triangle> tris;

	public GamePanel() {
		addKeyListener(this);
		setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
		
		setFocusable(true);
		requestFocus();
		
		// Create the simplest 3d shape, a tetrahedron
		tris = getTetrahedron();
		
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		// clear screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
		
		// TODO
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			break;
		case KeyEvent.VK_A:
			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_D:
			break;
		case KeyEvent.VK_E:
			break;
		case KeyEvent.VK_Q:
			break;
		case KeyEvent.VK_SPACE:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	private List<Triangle> getTetrahedron() {
		List<Triangle> output = new ArrayList<>();
		output.add(new Triangle(
					new Vertex(100, 100, 100),
		            new Vertex(-100, -100, 100),
		            new Vertex(-100, 100, -100)
				  ));
		output.add(new Triangle(
					new Vertex(100, 100, 100),
		            new Vertex(-100, -100, 100),
		            new Vertex(100, -100, -100)
		          ));
		output.add(new Triangle(
					new Vertex(-100, 100, -100),
		            new Vertex(100, -100, -100),
		            new Vertex(100, 100, 100)
		          ));
		output.add(new Triangle(
					new Vertex(-100, 100, -100),
		            new Vertex(100, -100, -100),
		            new Vertex(-100, -100, 100)
		          ));
		
		return output;
	}
}
