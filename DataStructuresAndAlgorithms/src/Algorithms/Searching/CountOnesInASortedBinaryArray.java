/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class CountOnesInASortedBinaryArray {
    private CountOnesInASortedBinaryArray() {}
    
    public static int solution(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left  <= right) {
            int mid = (left+right)/2;
            
            if(arr[mid] == 0) {
                left = mid+1;
            } else {
                if(mid == 0 || arr[mid-1] != 1) {
                    return n-mid;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return 0;
    }
}
