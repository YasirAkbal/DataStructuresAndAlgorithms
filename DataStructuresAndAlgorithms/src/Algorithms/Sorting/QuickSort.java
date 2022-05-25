/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting;

import Utils.ArrayUtils;

/**
 *
 * @author yasir
 */
public final class QuickSort {
    private QuickSort() {}
    
    private static ArrayUtils<Integer> util = new ArrayUtils<>();
    
    public static void quickSort(Integer[] arr) {
        _quickSort(arr,0,arr.length-1);
    }
    
    private static void _quickSort(Integer[] arr, int left, int right) {
        if(right - left <= 1) { return; }
        
        int partitionIndex = partition(arr, left, right);
        
        _quickSort(arr,left,partitionIndex-1);
        _quickSort(arr,partitionIndex+1,right);
    }
    
    private static int partition(Integer[] arr, int left, int right) {
        int i=left+1;
        int j=right;
        int pivot = arr[left];
        
        while(i < j) {
            while(i <= right && arr[i] <= pivot) { i++; }
            while(j > 0 && arr[j] > pivot) { j--; }
            
            if(i < j) {
                util.swap(arr, i, j);
            }
        }
        
        arr[left] = arr[j];
        arr[j] = pivot;
        
        return j;
    }
}
