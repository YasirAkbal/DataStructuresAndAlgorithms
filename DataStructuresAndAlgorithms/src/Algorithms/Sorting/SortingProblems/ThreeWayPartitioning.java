/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 * Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified array.
 */
public final class ThreeWayPartitioning {
    private ThreeWayPartitioning() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    public void threeWayPartition(int arr[], int a, int b)
    {
        int left = 0;
        int mid = 0;
        int right = arr.length-1;
        
        while(mid <= right) {
            if(arr[mid] >= a && arr[mid] <= b) {
                mid++;
            } else if(arr[mid] < a) {
                util.swap(arr, left, mid);
                left++;
                mid++;
            } else { //arr[mid] > b
                util.swap(arr, mid, right);
                right--;
            }
        }
    }
}
