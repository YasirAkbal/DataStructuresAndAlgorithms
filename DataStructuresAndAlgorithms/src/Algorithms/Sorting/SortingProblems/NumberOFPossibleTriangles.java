/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Utils.IntArrayUtils;
import java.util.Arrays;

/**
 *
 * @author yasir
 * Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 
 */
public final class NumberOFPossibleTriangles {
    private NumberOFPossibleTriangles() {}
    
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int result = 0;
        
        for(int i=2;i<n;i++) {
            result += countPairs(arr,i);
        }
        
        return result;
    }
    

    private static int countPairs(int[] arr, int i) {
        int left = 0;
        int right = i-1;
        int x = arr[i];
        int count = 0;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum <= x) {
                left++;
            } else {
                count += (right-left);
                right--;
            }
        }
        return count;
    }
}
