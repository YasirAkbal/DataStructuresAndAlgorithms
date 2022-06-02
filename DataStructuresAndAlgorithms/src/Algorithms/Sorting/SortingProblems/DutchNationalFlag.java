/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 */
public final class DutchNationalFlag {
    private DutchNationalFlag() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    public static void solution(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        
        while(mid <= high){
            if(arr[mid] == 0) {
                util.swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                util.swap(arr, mid, high);
                high--;
            }
        }
    }
}
