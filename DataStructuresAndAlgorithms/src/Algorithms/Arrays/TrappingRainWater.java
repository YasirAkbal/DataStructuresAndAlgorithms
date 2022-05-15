/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class TrappingRainWater {
    private TrappingRainWater() {}
    
    public static int solution1(int[] arr) {        
        int collected = 0;
        
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        
        leftMax[0] = arr[0];
        for(int i=1;i<arr.length;i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }
        
        rightMax[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>0;i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        }
        
        for(int i=1;i<arr.length-1;i++) {
            collected += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
    
        return collected;
    }
}
