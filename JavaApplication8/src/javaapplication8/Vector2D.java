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
public class Vector2D {
    
    private double x;
    private double y;
	
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2D() {
	this.x = 0;
	this.y = 0;
    }
    
    public double getDouble(int p) {
        if(p == 0)
            return this.x;
        else if(p == 1)
            return this.y;
        return -1;
    }
    
    public void setVector(int p, int n) {
        if(p == 0)
            this.x = n;
        else if(p == 1)
            this.y = n;
    }
    public Vector2D add(Vector2D v) {
	return new Vector2D(this.x+v.x,this.y+v.y);
    }
    
    public double mult(Vector2D v) {
	return this.x*v.x + this.y*v.y;
    }
	
    public Vector2D scale(int factor) {
	return new Vector2D(this.x*factor,this.y*factor);
    }  
	
    public String toString() {
	return "( " +this.x+" , " +this.y+" )";
    }
    
    public static void main(String[] args) {
        
    }
}
