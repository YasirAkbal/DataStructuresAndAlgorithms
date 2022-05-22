/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class BinarySearch {
    private BinarySearch() {}
    
    public static int iterative(int[] arr, int x) {
        int left = 0;
        int right = arr.length-1;
        
        while(right >= left) {
            int mid = (left+right)/2;
            
            if(arr[mid] == x) {
                return mid;
            } else if(arr[mid] > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return -1;
    }
    
    public static int recursive(int[] arr, int x) {
        return _recursive(arr, 0, arr.length-1, x);
    }
    
    public static int _recursive(int[] arr, int left, int right, int x) {
        if(left > right) { return -1; }
        
        int mid = (left+right)/2;
        
        if(arr[mid] == x) { return mid; }
        else if(arr[mid] > x) {
            return _recursive(arr, left, mid-1, x);
        } else {
            return _recursive(arr, mid+1, right, x);
        }
    }
}
