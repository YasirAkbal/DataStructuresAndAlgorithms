/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashMap;

/**
 *
 * @author yasir
 */
public class LongestSubArrayWithGivenSum {
    public static int solution(int[] arr, int sum){
        int n = arr.length;
        int result = 0;
        int prefixSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            prefixSum += arr[i];
            if(map.containsKey(prefixSum-sum)) {
                result = Math.max(result, i-map.get(prefixSum-sum));
            }
            if(prefixSum == sum) {
                result = i+1;
            }
            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return result;
    }
}
