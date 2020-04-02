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
	updateVect();
    }
	
    public Matrix2x2() {
	this.data[0][0] = 1;
	this.data[1][0] = 0;
	this.data[0][1] = 0;
	this.data[1][1] = 1;
	updateVect();
    }
    
    public double getData(int row, int column) {
	return this.data[row][column];
    }
	
    public Vector2D getRow(int p) {
	if (p == 0) {
            return this.row0;
	} 
        else if (p == 1) {
            return this.row1;
	} 
        else {
            return new Vector2D();
        }
    }
	
    public Vector2D getCol(int p) {
	if (p == 0) {
            return this.col0;
	}
        else if (p == 1) {
            return this.col1;
	} 
        else {
            return new Vector2D();
        }
    }
    public void setData(int row, int column, double setNum) {
	this.data[row][column] = setNum;
    }
	
    public void setRow(int row, Vector2D inRow) {
	if (row == 0) {
            this.row0 = inRow;
	} 
        else if (row == 1) {
            this.row1 = inRow;
	}
        updateVect(1);
	updateData();
    }
	
    public void setCol(int col, Vector2D inCol) {
	if (col == 0) {
            this.col0 = inCol;
	}
        else if (col == 1) {
            this.col1 = inCol;
	}
        updateVect(0);
	updateData();
    }
    public void updateVect() {
        this.row0 = new Vector2D(this.data[0][0], this.data[0][1]);
	this.row1 = new Vector2D(this.data[1][0], this.data[1][1]);
	this.col0 = new Vector2D(this.data[0][0], this.data[1][0]);
	this.col1 = new Vector2D(this.data[0][1], this.data[1][1]);
    }
    
    public void updateVect(int orientation) {
	if (orientation == 0) {
            this.row0 = new Vector2D(this.data[0][0], this.data[0][1]);
            this.row1 = new Vector2D(this.data[1][0], this.data[1][1]);
	} 
        else if (orientation == 1) {
            this.col0 = new Vector2D(this.data[0][0], this.data[1][0]);
            this.col1 = new Vector2D(this.data[0][1], this.data[1][1]);
	}
    }
    
    public void updateData() {
	for (int i = 0; i < 2; i++) {
            setData(0, i, row0.getDouble(i));
            setData(1, i, row1.getDouble(i));
	}
    }
    
    public void updateData(int orientation) {
	if (orientation == 0) {
            updateVect();
	} 
        else if(orientation == 1) {
            for (int i = 0; i < 2; i++) {
		setData(i, 0, col0.getDouble(i));
		setData(i, 1, col1.getDouble(i));
            }
        }
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
    
    @Override
    public String toString() {
        return ("(" + this.row0 + ") , (" + this.row1 + ")");
    }

    public static void main(String[] args) {
    }
}
