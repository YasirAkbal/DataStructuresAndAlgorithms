/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

import java.util.Arrays;

/**
 *
 * @author yasir
 */
public final class MaximumCircularSubarraySum {
    private MaximumCircularSubarraySum() { }
    
    
    //BigTheta(n^2)
    public static int solution1(int[] arr) {
        int result = arr[0];
        for(int i=0;i<arr.length;i++) {
            int currentMax = arr[i];
            int currentSum = arr[i];
            for(int j=1;j<arr.length;j++) {
                int index = (i+j)/arr.length;
                currentSum += arr[index];
                currentMax = Math.max(currentMax, currentSum);
            }
            result = Math.max(result, currentMax);
        }
        return result;
    }
    
    //BigTheta(n)
    public static int solution2(int[] arr) {
        int normalArrSubArraysMax = MaximumSumSubarray.solution2(arr);
        int minSubArraySum = minSubArraySum(arr);
        int sumOfArray = Arrays.stream(arr).sum();
        int rotatedArraySubArraysMax = sumOfArray - minSubArraySum;
        
        return Math.max(normalArrSubArraysMax, rotatedArraySubArraysMax);
    }
    
    private static int minSubArraySum(int[] arr) {
        int minEnding = arr[0];
        int result = arr[0];
        
        for(int i=1;i<arr.length;i++) {
            minEnding = Math.min(minEnding+arr[i], arr[i]);
            result = Math.min(result, minEnding);
        }
        
        return result;
    }
}
