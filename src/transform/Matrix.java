package transform;

import graphics.Triangle;
import graphics.Vertex;

// Matrix for transforming 3d objects
// currently only supports 3x3 matrices
public class Matrix {
    double[][] values;
    
    public Matrix(double[][] values) {
        this.values = values;
    }
    
    // apply this transformation to a vertex
    public Vertex transform(Vertex v) {
        return new Vertex(
            v.x * values[0][0] + v.y * values[0][1] + v.z * values[0][2],
            v.x * values[1][0] + v.y * values[1][1] + v.z * values[1][2],
            v.x * values[2][0] + v.y * values[2][1] + v.z * values[2][2]
        );
    }
    
    // apply this transformation to a triangle, and update the triangle
    public void transform(Triangle t) {
    	t.v1 = transform(t.v1);
    	t.v2 = transform(t.v2);
    	t.v3 = transform(t.v3);
    }
}
