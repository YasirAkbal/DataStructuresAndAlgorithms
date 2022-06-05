/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

/**
 *
 * @author yasir
 */
public final class MatrixMultiply {
    private MatrixMultiply() {}
    
    static int[][] multiplyMatrix(int A[][], int B[][])
    {
        int aN = A.length;
        int aM = A[0].length;
        int bN = B.length;
        int bM = B[0].length;
        
        if(aM != bN) {
            int[][] r = {{-1}};
            return r;
        }
        
        int result[][] = new int[aN][bM];
        
        for(int i=0;i<aN;i++) {
            for(int j=0;j<bM;j++) {
                for(int k=0;k<aM;k++) {
                    result[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        
        return result;
    }
}
