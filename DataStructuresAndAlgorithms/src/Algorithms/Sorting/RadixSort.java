/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting;

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
    
    public static void radixSort(Integer[] arr) {
        int n = arr.length;
        int max = CountingSort.findMax(arr);
        int numberOfDigits = (int)(Math.log(max) / Math.log(BASE));
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
                while(bins[i].size() > 0) {
                    arr[j++] = (Integer)bins[i].remove(0);
                }
            }
        }
    }
}
