/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Arrays;

/**
 *
 * @author yasir
 */
public final class MoveZerosToEnd {
    private MoveZerosToEnd() {}
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void solution(int[] arr) {
        int counter = 0; //dizide 0 sayısının bulunduğu en küçük indeksi tutuyor
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                swap(arr,i,counter);
                counter++;
            }
        }
    }
}
