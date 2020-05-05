package transform;

import java.util.List;

import graphics.Triangle;

// utility class that takes 3d meshes and rotates them around an axis
public class Rotator {
	public static void rotateX(List<Triangle> mesh, double theta) {
		// build the rotation matrix
		double[][] rotationValues = new double[3][3];
		rotationValues[0] = new double[] {1, 			0, 					0};
		rotationValues[1] = new double[] {0, 			Math.cos(theta), 	Math.sin(theta)};
		rotationValues[2] = new double[] {0, 			-Math.sin(theta), 	Math.cos(theta)};
		Matrix rotationMatrix = new Matrix(rotationValues);
		
		// transform the mesh
		for(Triangle t : mesh) {
			rotationMatrix.transform(t);
		}
	}
	
	public static void rotateY(List<Triangle> mesh, double theta) {
		// build the rotation matrix
		double[][] rotationValues = new double[3][3];
		rotationValues[0] = new double[] {Math.cos(theta), 	0, 			-Math.sin(theta)};
		rotationValues[1] = new double[] {0, 				1, 			0};
		rotationValues[2] = new double[] {Math.sin(theta), 	0, 			Math.cos(theta)};
		Matrix rotationMatrix = new Matrix(rotationValues);
		
		// transform the mesh
		for(Triangle t : mesh) {
			rotationMatrix.transform(t);
		}
	}
	
	public static void rotateZ(List<Triangle> mesh, double theta) {
		// build the rotation matrix
		double[][] rotationValues = new double[3][3];
		rotationValues[0] = new double[] {Math.cos(theta), 	-Math.sin(theta),	0};
		rotationValues[1] = new double[] {Math.sin(theta), 	Math.cos(theta), 	0};
		rotationValues[2] = new double[] {0, 				0, 					1};
		Matrix rotationMatrix = new Matrix(rotationValues);
		
		// transform the mesh
		for(Triangle t : mesh) {
			rotationMatrix.transform(t);
		}
	}
}
