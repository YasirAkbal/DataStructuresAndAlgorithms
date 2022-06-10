/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

/**
 *
 * @author yasir
 */
public class LongestCommonSubarrayWithGivenSum {
    public static int solution(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int result = 0;
        int sum1, sum2;
        
        for(int i=0;i<n;i++) {
            sum1 = 0; sum2 = 0;
            for(int j=i;j<n;j++) {
                sum1 += arr1[j];
                sum2 += arr2[j];
                if(sum1 == sum2) {
                    result = Math.max(result,j-i+1);
                }
            }
        }
        
        return result;
    }
    
    public static int efficientSolution(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] diffArr = new int[n];
        
        for(int i=0;i<n;i++)
            diffArr[i] = arr1[i] - arr2[i];
        
        return LongestSubArrayWithGivenSum.solution(diffArr, 0);
    }
}
