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
public final class BubbleSort {
    private static ArrayUtils<Integer> util = new ArrayUtils<>();
    
    private BubbleSort() {}
    
    public static void run(Integer[] arr) {
        int n = arr.length;
        boolean anySwap;
        
        for(int i=0;i<n-1;i++) {
            anySwap = false;
            for(int j=0;j<n-i-1;j++) { //her i pass işleminde sonra dizinin son i elemanı sıralı olur. Bunları tekrar kontrol etme 
                if(arr[j] > arr[j+1]) {
                    util.swap(arr, j, j+1);
                }
            }
            if(anySwap == false) { //pass işlemi sonunda hiç swap olmamışsa dizi zaten sıralıdır.
                break;
            }
        }
    }
}
