/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashMap;

/**
 *
 * @author yasir
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 */
public class LongestSubArrayWithEq0And1 {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int sum = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        
        for(int i=0;i<n;i++) {
            sum += nums[i];
            if(map.containsKey(sum)) {
                max = Math.max(max,i-map.get(sum));
            }
            if(sum == 0) {
                max = i+1;
            }
            if(!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        
        return max;
    }
}
