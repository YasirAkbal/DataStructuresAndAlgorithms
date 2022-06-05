/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Matrix;

import java.util.ArrayList;

/**
 *
 * @author yasir
 */
public final class PrintInSnakePattern {
    private PrintInSnakePattern() {}
    
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                int index = (i%2==0) ? j : matrix[i].length-j-1;
                result.add(matrix[i][index]);
            }
        }
        
        return result;
    }   
}
