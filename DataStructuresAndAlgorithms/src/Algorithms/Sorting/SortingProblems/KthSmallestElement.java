/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Algorithms.Sorting.SortingAlgorithms.QuickSort;

/**
 *
 * @author yasir
 */
public final class KthSmallestElement {
    private KthSmallestElement() {}
    
    
    /*
    Time Complexity: O(n^2) , Average -> BigTheta(n)
    */
    public static int solution(Integer[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int parIndex = QuickSort.partition(arr, left, right);
            
            if(parIndex == k-1){
                return arr[parIndex];
            } else if(parIndex > k-1) {
                right = parIndex-1;
            } else {
                left = parIndex+1;
            }
        } 
        
        return -1;
    }
}
