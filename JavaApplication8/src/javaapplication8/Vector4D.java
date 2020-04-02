/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author Rahul
 */
public class Vector4D {
	
    public static void main(String[] args) {
    }
    private double x;
    private double y;
    private double z;
    private double w;
	
    public Vector4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }   
	
    public Vector4D(Vector2D first, Vector2D second) {
        this.x = first.getDouble(0);
        this.y = first.getDouble(1);
        this.z = second.getDouble(0);
        this.w = second.getDouble(1);
    }
	
    public Vector4D(Matrix2x2 mat) {
        new Vector4D(mat.getRow(0), mat.getRow(1));
    }	
	
    public Vector4D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
	
    public void set(int place, double setNum) {
        if (place == 0) {
            this.x = setNum;
        }
        else if (place == 1) {
            this.y = setNum;
        }
        else if (place == 2) {
            this.z = setNum;
        } 
        else if (place == 3) {
            this.w = setNum;
        }
    }
	
    public double get(int place) {
        if (place == 0) {
            return this.x;
        } 
        else if (place == 1) {
            return this.y;
        } 
        else if (place == 2) {
            return this.z;
        } 
        else if (place == 3) {
            return this.w;
        } 
        return 0;
    }
	
    public String toString() {
        return "(" + new Vector2D(this.x, this.y)+ " , " + new Vector2D(this.z, this.w) + ")";
    }
	
    public Vector4D add(Vector4D otherVect) {
        return new Vector4D(this.x + otherVect.x,this.y + otherVect.y,this.z + otherVect.z,this.w + otherVect.w);
    }
	
    public double mult(Vector4D otherVect) {
        return this.x * otherVect.x + this.y * otherVect.y +this.z * otherVect.z +this.w * otherVect.w;
    }
	
    public Vector4D scale(int scaleFact) {
        return new Vector4D(this.x * scaleFact,this.y * scaleFact,this.z * scaleFact,this.w * scaleFact);
    }
}
