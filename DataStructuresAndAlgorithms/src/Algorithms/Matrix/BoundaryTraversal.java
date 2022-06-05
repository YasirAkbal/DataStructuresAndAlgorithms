/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * You are given a matrix of dimensions n x m. The task is to perform boundary traversal on the matrix in a clockwise manner. 
 */
public class BoundaryTraversal {
    
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if(n==1) {
            for(int i=0;i<m;i++) {
                result.add(matrix[0][i]);
            }
        } else if(m==1) {
            for(int i=0;i<n;i++) {
                result.add(matrix[i][0]);
            }
        } else {
            for(int i=0;i<m-1;i++) {
                result.add(matrix[0][i]);
            }
            
            for(int i=0;i<n;i++) {
                result.add(matrix[i][m-1]);
            }
            
        
            for(int i=m-2;i>=0;i--) {
                result.add(matrix[n-1][i]);
            } 
            
            
            for(int i=n-2;i>=1;i--) {
                result.add(matrix[i][0]);
            }
        }
        
        return result;
    }
    
}
