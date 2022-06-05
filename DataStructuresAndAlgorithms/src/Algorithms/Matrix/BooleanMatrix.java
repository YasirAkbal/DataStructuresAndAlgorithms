/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

/**
 *
 * @author yasir
 * Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.
 */
public class BooleanMatrix {
    void booleanMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean row_flag = false;
        boolean col_flag = false;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i == 0 && matrix[i][j] == 1)
                    row_flag = true;
                
                if(j == 0 && matrix[i][j] == 1) 
                    col_flag = true;
                    
                if(matrix[i][j] == 1) {
                    matrix[0][j] = 1;
                    matrix[i][0] = 1;
                }
            }
        }
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(matrix[i][0] == 1 || matrix[0][j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
        
        if(row_flag) {
            for(int i=0;i<m;i++) {
                matrix[0][i] = 1;
            }
        }
        
        if(col_flag) {
            for(int i=0;i<n;i++) {
                matrix[i][0] = 1;
            }
        }
    }
}
