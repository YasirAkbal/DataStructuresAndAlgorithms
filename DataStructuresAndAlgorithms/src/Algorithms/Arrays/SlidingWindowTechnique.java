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
public final class SlidingWindowTechnique {
    private SlidingWindowTechnique() {}
    
    /*
    Verilen dizide k boyutlu alt dizilerden en büyük toplama sahip olanı bulan algoritma
    */
    public static int maxKConsecutiveElements(int[] arr, int k){
        if(arr.length <= k) { Arrays.stream(arr).sum(); }
        
        int result = 0;
        for(int i=0;i<k;i++) {
            result += arr[i];
        }
        
        int sum = result;
        for(int i=k;i<arr.length;i++) {
            sum = sum-arr[i-k]+arr[i];
            result = Math.max(result, sum);
        }
       
        return result;
    }
    
    /*
    Elemanlarını negatif olmayan dizide verilen sum değerine eşit alt diziyi bulan program
    */
    public static boolean findSubarrayWithGivenSum(int[] arr, int sum) {
        int currentSum = 0;
        int start = 0;
        
        for(int end=0;end<arr.length;end++) {
            
            while(currentSum > sum && start < end-1) {
                currentSum -= arr[start];
                start++;
            }
            
            if(currentSum == sum) { return true; }
            if(end < arr.length) {
                currentSum += arr[end];
            }
        }
        
        return (currentSum == sum);
    }
    
    
    public static void N_BonacciNumber(int N, int M) {
        //to do
    }
}
