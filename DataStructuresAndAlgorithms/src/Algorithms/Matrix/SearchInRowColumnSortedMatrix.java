/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

/**
 *
 * @author yasir
 * Given a matrix of size n x m, where every row and column is sorted in increasing order, and a number x. Find whether element x is present in the matrix or not.
 */
public class SearchInRowColumnSortedMatrix {
    static boolean search(int matrix[][], int n, int m, int x) {  
        int i = 0, j = m-1;
        
        while(i < n && j >= 0) {
            if(matrix[i][j] == x) {
                return true;
            } else if(matrix[i][j] < x) {
                i++;
            } else {
               j--; 
            }
        }
	    
	return false;
    }   
}
