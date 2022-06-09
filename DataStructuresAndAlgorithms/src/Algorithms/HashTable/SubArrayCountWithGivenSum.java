/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashMap;

/**
 *
 * @author yasir
 * Given an unsorted array of integers and a sum. The task is to count the number of subarray which adds to the given sum.
 */
public class SubArrayCountWithGivenSum {
    public static int subArraySum(int arr[], int n, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int result = 0;
        
        for(int i=0;i<n;i++) {
            prefixSum += arr[i];
            if(sum == prefixSum)
                result++;
            if(map.containsKey(prefixSum-sum))
                result += map.get(prefixSum-sum);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
         
        return result;
    }  
}
