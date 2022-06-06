/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * Given a matrix of size r*c. Traverse the matrix in spiral form.
 */
public class SpirallyTraversal {
    private static void boundaryTraversel(ArrayList<Integer> arrList, int matrix[][], int rowStart, int rowEnd, int colStart, int colEnd) {
        for(int j=colStart;j<=colEnd-1;j++)
            arrList.add(matrix[rowStart][j]);
        
        for(int i=rowStart;i<=rowEnd;i++)
            arrList.add(matrix[i][colEnd]);
        
        for(int j=colEnd-1;j>=colStart;j--)
            arrList.add(matrix[rowEnd][j]);
        
        for(int i=rowEnd-1;i>=rowStart+1;i--)
            arrList.add(matrix[i][colStart]);
    }
    
    private static void recSolution(ArrayList<Integer> arrList, int matrix[][], int rowStart, int rowEnd, int colStart, int colEnd) {
        if(rowStart > rowEnd || colStart > colEnd) { return; }
        
        if(rowStart < rowEnd && colStart < colEnd) {
            boundaryTraversel(arrList,matrix,rowStart,rowEnd,colStart,colEnd);
        } else if(rowStart == rowEnd) {
            for(int j=colStart;j<=colEnd;j++)
                arrList.add(matrix[rowStart][j]);
        } else if(colStart == colEnd){
            for(int i=rowStart;i<=rowEnd;i++)
                arrList.add(matrix[i][colStart]);
        }
        
        recSolution(arrList, matrix, rowStart+1, rowEnd-1, colStart+1, colEnd-1);
    }
    
    public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> result = new ArrayList<>();
        
        recSolution(result,matrix,0,r-1,0,c-1);
        
        return result;
    } 
}
