/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class SecondLargestInArray {
    private SecondLargestInArray() {}
    
    public static int solution(int[] arr) {
        int first = 0;
        int second = -1;
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > arr[first]) {
                second = first;
                first = i;
            } else if(arr[i] < arr[first]) {
                if(second == -1) { second = i; }
                else if(arr[i] > arr[second]) { second = i; }
            }
        }
        
        return second;
    }
}
