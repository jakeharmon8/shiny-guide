package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Triangle {
    public Vertex v1;
    public Vertex v2;
    public Vertex v3;
    public Color color;
    

    
    public Triangle(Color color, Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
    
    public void draw(Graphics g) {
    	drawLine(v1, v2, g);
    	drawLine(v2, v3, g);
    	drawLine(v3, v1, g);
    
    }
    
    public void rasterize(BufferedImage img, double [][] zbuffer) {
    	int x_off = GamePanel.S_WIDTH / 2;
        int y_off = GamePanel.S_HEIGHT / 2;

        // find the bounds
        // compute rectangular bounds for triangle
        int minX = (int) Math.ceil(Math.min(v1.x, Math.min(v2.x, v3.x)));
        int maxX = (int) Math.floor(Math.max(v1.x, Math.max(v2.x, v3.x)));
        int minY = (int) Math.ceil(Math.min(v1.y, Math.min(v2.y, v3.y)));
        int maxY = (int) Math.floor(Math.max(v1.y, Math.max(v2.y, v3.y)));

        double triangleArea = (v1.y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - v1.x);

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                double b1 = 
                  ((y - v3.y) * (v2.x - v3.x) + (v2.y - v3.y) * (v3.x - x)) / triangleArea;
                double b2 =
                  ((y - v1.y) * (v3.x - v1.x) + (v3.y - v1.y) * (v1.x - x)) / triangleArea;
                double b3 =
                  ((y - v2.y) * (v1.x - v2.x) + (v1.y - v2.y) * (v2.x - x)) / triangleArea;
                double depth = b1 * v1.z + b2 * v2.z + b3 * v3.z;
                if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1 && (depth > zbuffer[x+x_off][y+y_off])) {
                    img.setRGB(x + x_off, y + y_off, color.getRGB());
                    zbuffer[x+x_off][y+y_off] = depth;
                }
                
            }
        }
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
