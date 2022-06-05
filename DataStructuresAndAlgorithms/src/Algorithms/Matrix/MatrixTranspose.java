/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 */
public final class MatrixTranspose {
    private MatrixTranspose() {} 
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    static void transpose(int matrix[][], int n)
    {
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                util.swap(matrix,i,j);
            }
        }
    }
}
