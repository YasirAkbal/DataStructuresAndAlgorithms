/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting;

import java.util.Arrays;

/**
 *
 * @author ahmetyasir
 */
public final class CountingSort {
    private CountingSort() {}
    
    /*
    0 ile max arasında elemanları olan bir dizi verilmişse lineer zamanda sıralanabilir.
    TimeComplexity -> BigTheta(n+max), max -> dizideki en büyük eleman
    Auxiliary Space -> BigTheta(max)
    */
    public static void countSort(Integer[] arr) {
        int max = findMax(arr);
        Integer[] counts = new Integer[max+1];
        Arrays.fill(counts, 0); //n
        
        for(int number: arr) { //n
            counts[number]++;
        }
        
        int i = 0;
        for(int j=0;j<counts.length;) { //max
            if(counts[j] > 0) {
                arr[i++] = j;
                counts[j]--;
            } else {
                j++;
            }
        }
    }
    
    public static int findMax(Integer[] arr) {
        int max = arr[0];
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
    }
}
