/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

import Utils.ArrayUtils;

/**
 *
 * @author yasir
 */
public final class SelectionSort {
    private SelectionSort() {}
    
    private static ArrayUtils<Integer> utils = new ArrayUtils<>();
    
    public static void run(Integer[] arr) {
        int n = arr.length;
        int k;
        
        for(int i=0;i<n-1;i++) {
            k = i;
            for(int j=i;j<n;j++) {
                if(arr[j] < arr[k]) {
                    k = j;
                }
            }
            utils.swap(arr, i, k);
        }
    }
}
