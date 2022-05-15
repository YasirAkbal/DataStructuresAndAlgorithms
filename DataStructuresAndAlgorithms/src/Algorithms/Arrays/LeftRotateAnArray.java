/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

import Utils.ArrayUtils;

/**
 *
 * @author yasir
 */
public final class LeftRotateAnArray {
    private static ArrayUtils<Integer> utils = new ArrayUtils<>();
    private LeftRotateAnArray() { }
    
    public static void leftRotateOne(int[] arr) {
        int first = arr[0];
        
        for(int i=0;i<arr.length-1;i++) {
            arr[i] = arr[i+1];
        }
        
        arr[arr.length-1] = first;
    }
    
    //Time Complexity -> BigTheta(n*d)
    //Auxiliary Space -> BigTheta(1)
    public static void leftRotateDTimesSolution1(int[] arr, int d) {
        for(int i=0;i<d;i++) {
            leftRotateOne(arr);
        }
    }
    
    
    //Time Complexity -> BigTheta(n)
    //Auxiliary Space -> BigTheta(n)
    public static void leftRotateDTimesSolution2(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[n];
        
        System.arraycopy(arr, 0, temp, 0, n);
        /*for(int i=0;i<arr.length;i++) {
            temp[i] = arr[i];
        }*/
              
        for(int i=0;i<n-d;i++) {
            arr[i] = temp[(i+d)%n];
        }
        
        for(int i=n-d;i<n;i++) {
            arr[i] = temp[(i+d)%n];
        }
    }
    
    
    
    //Time Complexity -> BigTheta(n)
    //Auxiliary Space -> BigTheta(d)
    public static void leftRotateDTimesSolution3(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[d];
        
        System.arraycopy(arr, 0, temp, 0, d);
        
        for(int i=0;i<n-d;i++) {
            arr[i] = arr[(i+d)%n];
        }
        
        for(int i=n-d;i<n;i++) {
            arr[i] = temp[(i+d)%n];
        }
    }
    
    
    
    //Time Complexity -> BigTheta(n)
    //Auxiliary Space -> BigTheta(1)
    public static void leftRotateDTimesSolution4(Integer[] arr, int d) {
        utils.reverse(arr, 0, d);
        utils.reverse(arr, d);
        utils.reverse(arr);  
    }
}
