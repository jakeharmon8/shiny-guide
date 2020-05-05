package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle {
    public Vertex v1;
    public Vertex v2;
    public Vertex v3;
    
    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    
    public void draw(Graphics g) {
    	// TODO
    }
    
    // draw a line from a to b
    // since we're not using the Z coordinate, 
    // this is kind of like looking down at the shape from above
    private void drawLine(Vertex a, Vertex b, Graphics g) {
    	int x_off = GamePanel.S_WIDTH / 2;
    	int y_off = GamePanel.S_HEIGHT / 2;
    	
    	g.drawLine((int)a.x + x_off, (int)a.y + y_off, (int)b.x + x_off, (int)b.y + y_off);
    }
}
