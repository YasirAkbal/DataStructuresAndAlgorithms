/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 * First Occurence in sorted array
 */
public final class FirstOccurence {
    private FirstOccurence() {}
    
    public static int recursive(int[] arr, int x) {
        return _recursive(arr,0,arr.length,x);
    }
    
    private static int _recursive(int[] arr, int left, int right, int x) {
        //klasik binary search bas
        if(left > right) { return -1; }
        
        int mid = (left+right)/2;
        
        if(arr[mid] > x) {
            return _recursive(arr, left, mid-1, x);
        } else if(arr[mid] < x) {
            return _recursive(arr, mid+1, right, x);
        } //klasik binary search son
        else {
            if(mid == 0 || arr[mid-1] != arr[mid]) {
                return mid;
            } else {
                return _recursive(arr, left, mid-1, x);
            }
        } 
    }
    
    public static int iterative(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            
            if(arr[mid] < x) {
                left = mid+1;
            } else if(arr[mid] > x) {
                right = mid-1;
            } else {
                if(mid == 0 || arr[mid-1] != arr[mid]) {
                    return mid;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return -1;
    }
}
