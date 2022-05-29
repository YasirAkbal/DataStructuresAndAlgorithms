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
public final class MergeSort {
    private MergeSort() {}
    
    private static ArrayUtils<Integer> util = new ArrayUtils<>();
    
    public static void iterative(Integer[] arr) {
        int n = arr.length;
        int left, right;
        int mid;
        int p;
        
        for(p=2;p<=n;p*=2) {
            for(int i=0;i+p-1<n;i+=p) {
                left = i;
                right = i+p-1;
                mid = (left+right)/2;
                util.merge(arr, left, mid, right);
            }
        }
        
        if(p/2<n) {
            util.merge(arr, 0, p/2-1, n-1);
        }
    }
    
    public static void recursive(Integer[] arr) {
        _recursive(arr,0,arr.length-1);
    }
    
    private static void _recursive(Integer[] arr, int left, int right) {
        if(left >= right) { return; }
        
        int mid = (left+right)/2; // left + (right-left)/2 yazmak daha iyi. overflow oluşmasını engeller
        
        _recursive(arr,left,mid);
        _recursive(arr,mid+1,right);
        
        util.merge(arr, left, mid, right);
    }
}
