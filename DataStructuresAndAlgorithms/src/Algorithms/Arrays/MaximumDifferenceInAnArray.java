/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 * j > i, max(arr[j]-arr[i])
 */
public final class MaximumDifferenceInAnArray {
    private MaximumDifferenceInAnArray() {}
    
    
    //BigTheta(n) 
    public static int solution(int[] arr) {
        int maxDiff = arr[1]-arr[0];
        int minVal = arr[0];
        
        for(int j=1;j<arr.length;j++) {
            maxDiff = Math.max(maxDiff, arr[j]-minVal);
            minVal = Math.min(minVal, arr[j]);
        }
        
        return maxDiff;
    }
}
