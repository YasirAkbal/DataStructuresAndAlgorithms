/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

/**
 *
 * @author yasir
 */
public final class BeautifulMatrix {
    private BeautifulMatrix() {}
    
    public static int findMinOperation(int matrix[][], int n) {
        int[] sumOfRows = new int[n];
        int[] sumOfCols = new int[n];
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sumOfRows[i] += matrix[j][i];
                sumOfCols[i] += matrix[i][j];
            }
            max = Math.max(max, Math.max(sumOfRows[i], sumOfCols[i]));
        }
        
        int result = 0;
        for(int i=0,j=0;i<n && j<n;) {
            int colRowMax = Math.max(sumOfRows[i], sumOfCols[j]);
            int add = max - colRowMax;
                
            sumOfRows[i] += add;
            sumOfCols[j] += add;
            result += add;
            
            if(sumOfRows[i] == max)
                i++;
            
            if(sumOfCols[j] == max)
                j++;
        }
        
        return result;
    }
}
