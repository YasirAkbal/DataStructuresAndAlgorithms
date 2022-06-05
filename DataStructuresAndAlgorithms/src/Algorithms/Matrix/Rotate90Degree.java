/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 * Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space. 
 */
public final class Rotate90Degree {
    private Rotate90Degree() {}
    
    private static IntArrayUtils util = new IntArrayUtils();

    static void rotateby90(int matrix[][], int n) { 
        //transpose
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                util.swap(matrix, i, j);
            }
        }
        
        //reverse columns
        for(int j=0;j<n;j++) {
            for(int i=0;i<n/2;i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
    }
}
