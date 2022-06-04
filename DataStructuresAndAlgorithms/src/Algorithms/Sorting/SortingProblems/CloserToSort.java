/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

/**
 *
 * @author yasir
 * Given an array arr[](0-based indexing) of N integers which is closer sorted (defined below) and an element x. The task is to find the index of element x if it is present. If not present, then print -1.
Closer Sorted: The first array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, maybe to the arr[i+1] or arr[i-1].
 */
public final class CloserToSort {
    private CloserToSort() {}
    
    static long closer(int arr[], int n, long x)
    {
        return binarySearch(arr,0,n-1,x);
    }
    
    private static int binarySearch(int[] arr, int left, int right, long x) {
        if(left <= right) {
            int mid = (left+right)/2;
            
            if(arr[mid] == x) {
                return mid;
            } else if(mid > 0 && arr[mid-1] == x) {
                return mid-1;
            } else if(mid < arr.length-1 && arr[mid+1] == x) {
                return mid+1;
            } else if(arr[mid] < x) {
                return binarySearch(arr,mid+2,right,x);
            } else {
                return binarySearch(arr,left,mid-2,x);
            }
        }
        
        return -1;
    }
}
