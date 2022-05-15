/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class MaximumConsecutiveOnes {
    private MaximumConsecutiveOnes() {}
    
    public static int solution(int[] arr) {
        int max = 0;
        
        int tempMax = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 1) {
                tempMax++;
            } else if(tempMax > 0) {
                if(tempMax > max) {
                    max = tempMax;
                }
                tempMax = 0;
            }
        }
        
        if(tempMax > max) {
            max = tempMax;
        }
        
        return max;
    }
}
