/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import java.util.Arrays;

/**
 *
 * @author yasir
 * Given an array arr[] of n integers. Check whether it contains a triplet that sums up to zero. 
 */
public final class TripletsWithZeroSum {
    private TripletsWithZeroSum() {}
    
    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++) {
            if(findPair(arr,i,-arr[i])) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean findPair(int[] arr, int i, int x) {
        int left = 0;
        int right = arr.length-1;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum < x || left == i) {
                left++;
            } else if(sum > x || right == i) {
                right--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
