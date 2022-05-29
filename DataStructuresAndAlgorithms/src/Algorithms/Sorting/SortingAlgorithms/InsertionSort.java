/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

/**
 *
 * @author yasir
 */
public final class InsertionSort {
    private InsertionSort() {}
    
    public static void run(int[] arr) {
        int n = arr.length;
        
        for(int i=1;i<n;i++) {
            int x = arr[i];
            int j = i-1;
            while(j > -1 && x < arr[j]) { // < yerine <= olsaydı algoritma non-stable olurdu
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = x;
        }
    }
}
