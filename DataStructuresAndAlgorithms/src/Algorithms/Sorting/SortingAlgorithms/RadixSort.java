/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

import Utils.ArrayUtils;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author ahmetyasir
 */
public final class RadixSort {
    private RadixSort() {}
    
    private final static int BASE = 10;
    
    //LinkedList kullanılarak gerçekleştirilmesi.(Bin Sort'tan faydalanır)
    public static void radixSort(Integer[] arr) {
        int n = arr.length;
        int max = CountingSort.findMax(arr);
        int numberOfDigits = (int)(Math.log(max) / Math.log(BASE))+1;
        LinkedList[] bins = new LinkedList[BASE]; 
        int power = 1;
        int index;
        
        for(int i=0;i<numberOfDigits;i++) {
            for(int j=0;j<arr.length;j++) {
               index = (arr[j]/power)%BASE;
               if(bins[index] == null) {
                   bins[index] = new LinkedList();
               } 
               bins[index].add(arr[j]);
            }
            moveBinsToArr(arr,bins);            
            Arrays.fill(bins, null);
            power *= BASE;
        }
    }
    
    private static void moveBinsToArr(Integer[] arr, LinkedList[] bins) {
        int j = 0;
        for(int i=0;i<bins.length;i++) {
            if(bins[i] != null) {
                while(!bins[i].isEmpty()) {
                    arr[j++] = (Integer)bins[i].remove(0);
                }
            }
        }
    }
    
    //Sadece array kullanarak gerçekleme.(Counting Sort'tan faydalanır)
    public static void radixSortWithCS(Integer[] arr) {
        int max = CountingSort.findMax(arr);
        int numberOfDigts = (int)(Math.log(max) / Math.log(BASE)) + 1;
        int power = 1;
        
        for(int i=0;i<numberOfDigts;i++) {
            countingSortForRadixSort(arr,power);
            power *= 10;
        } 
    }
    
    private static void countingSortForRadixSort(Integer[] arr, int power) {
        int n = arr.length;
        Integer[] counts = new Integer[BASE];
        Arrays.fill(counts, 0);
        
        for(int i=0;i<n;i++) {
            counts[(arr[i]/power)%BASE]++;
        }
        
        for(int i=1;i<counts.length;i++) {
            counts[i] += counts[i-1];
        }
        
        Integer[] output = new Integer[n];
        for(int i=n-1;i>=0;i--) {
            output[counts[(arr[i]/power)%BASE]-1] = arr[i];
            counts[(arr[i]/power)%BASE]--;
        }
        
        for(int i=0;i<n;i++) {
            arr[i] = output[i];
        }
    }
}
