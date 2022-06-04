/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 * Given a binary array A[] of size N. The task is to arrange the array in increasing order.
Note: The binary array contains only 0  and 1.
 */
public final class BinaryArraySorting {
    private BinaryArraySorting() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    static void binSort(int arr[], int N)
    {
        int left = 0;
        int right = N-1;
        
        while(left < right) {
            while(left < N && arr[left] == 0) { left++; }
            while(right >= 0 && arr[right] == 1) { right--; }
            
            if(left < right) {
                util.swap(arr,left,right);
            }
        }
    }
}
