/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class FreqInSortedArray {
    private FreqInSortedArray() {}
    
    public static void solution1(int[] arr) {
        int count = 1;

        for(int i=1;i<arr.length;i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                System.out.println(arr[i-1] + " " + count);
                count = 1;
            }
        }
       
        System.out.println(arr[arr.length-1] + " " + count);
    }
}
