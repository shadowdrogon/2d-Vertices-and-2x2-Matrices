/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author rahur
 */
public class Matrix2x2 {
    
    private double[][] data = new double[2][2];
    private Vector2D row0;
    private Vector2D row1;
    private Vector2D col0;
    private Vector2D col1;
    public Matrix2x2(double m00, double m01, double m10, double m11) {
        this.data[0][0] = m00;
        this.data[0][1] = m01;
	this.data[1][0] = m10;
	this.data[1][1] = m11;
	this.updateVect();
    }
	
    public Matrix2x2() {
	this.data[0][0] = 1;
	this.data[1][0] = 0;
	this.data[0][1] = 0;
	this.data[1][1] = 1;
	this.updateVect();
    }

    public void updateVect() {
        this.row0 = new Vector2D(this.data[0][0], this.data[0][1]);
	this.row1 = new Vector2D(this.data[1][0], this.data[1][1]);
	this.col0 = new Vector2D(this.data[0][0], this.data[1][0]);
	this.col1 = new Vector2D(this.data[0][1], this.data[1][1]);
    }
	
    public Matrix2x2 add(Matrix2x2 otherMat) {
        double v1 = this.data[0][0] + otherMat.data[0][0];
        double v2 = this.data[0][1] + otherMat.data[0][1];
        double v3 = this.data[1][0] + otherMat.data[1][0];
        double v4 = this.data[1][1] + otherMat.data[1][1];
        return new Matrix2x2(v1, v2, v3, v4);
    }
	
    public Matrix2x2 mult(Matrix2x2 otherMat) {
	return new Matrix2x2(this.row0.mult(otherMat.col0),this.row0.mult(otherMat.col1),this.row1.mult(otherMat.col0),this.row1.mult(otherMat.col1));
    }
	
    public Matrix2x2 scale(double scaleFact) {
        return new Matrix2x2(this.data[0][0]*scaleFact,this.data[0][1]*scaleFact,this.data[1][0]*scaleFact,this.data[1][1]*scaleFact);
    }
	
    public Matrix2x2 inverse() {
	double d = (this.data[0][0] * this.data[1][1] -this.data[0][1] * this.data[1][0]);
	return new Matrix2x2(this.data[1][1],this.data[0][1] * -1,this.data[1][0] * -1,this.data[0][0]).scale(1/d);
    }
    	
    public String toString() {
        return ("(" + this.row0 + ") , (" + this.row1 + ")");
    }

    	
    public static void main(String[] args) {
        
    }
}
