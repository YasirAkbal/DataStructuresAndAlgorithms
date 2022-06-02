/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Algorithms.Sorting.SortingAlgorithms.QuickSort;
import Utils.ArrayUtils;
import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 * Negatif ve pozitif elemanlardan oluşan diziyi şu kurallara göre sırala:
 *      -Negatif sayılar dizinin ilk yarısında, pozitifler diğer yarısında olacak
 */
public final class SortArrayNegativeAndPositive {
    private SortArrayNegativeAndPositive() {}
    
    private static ArrayUtils<Integer> util = new ArrayUtils();
    
    public static void solution(Integer[] arr) {
        final int n = arr.length;
        Integer[] temp = new Integer[n];
        
        int minIndex = -1;
        int maxIndex = -1;
        int j = 0;
        int k = n-1;
        
        for(int i=0;i<n;i++) {
            if(arr[i] < 0) {
                temp[j] = arr[i];
                if(minIndex == -1 || arr[i] < temp[minIndex]) {
                    minIndex = j;
                }
                j++;
            } else {
                temp[k] = arr[i];
                if(maxIndex == -1 || arr[i] >= temp[maxIndex]) {
                    maxIndex = k;
                }
                k--;
            }
        }
        
        util.swap(temp,0,minIndex);
        util.swap(temp,n-1,maxIndex);
        
        System.arraycopy(temp, 0, arr, 0, n);
    }
    
    public static void efficientSolution(Integer[] arr) {
        int n = arr.length;
        int posMinIndex = findPositiveMin(arr); //partition kısmındaki if ifadeleri modifike edilerek yapılırsa dizide en küçük pozitif sayının bulunmasına gerek kalmaz. Dizi 1 kere traverse edilmiş olur.
        
        util.swap(arr, posMinIndex, 0);
        QuickSort.partition(arr, 0, n-1);
        
        //QuickSort.partitionWithCustomPivot(arr, 0, n-1, 0);  //Yukarıdaki kodlar yerine bu kullanılabilir.
    }
    
    private static int findPositiveMin(Integer[] arr) {
        int posMin = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0 && arr[i] <= posMin) {
                posMin = arr[i];
                index = i;
            }
        }
        return index;
    }
}
