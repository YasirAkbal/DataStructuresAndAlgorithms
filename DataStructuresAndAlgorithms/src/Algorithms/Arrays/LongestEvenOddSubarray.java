/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class LongestEvenOddSubarray {
    private LongestEvenOddSubarray() {}
    
    
    //BigTheta(n)
    public static int solution1(int[] arr) {
        int maxCount = 0;
        int currentCount = 1;
        boolean isPrevEven = arr[0] % 2 == 0;
        
        for(int i=1;i<arr.length;i++) {
            if(isPrevEven ^ (arr[i] % 2 == 0)) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
            }
            isPrevEven = (arr[i] % 2 == 0);
        }    
        
        //en sondaki seriyi döngü yakalamadıgı için ekstra kontrol
        return Math.max(maxCount, currentCount);
    }
}
