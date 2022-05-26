/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author ahmetyasir
 */

/*
Count Sort'a benziyor. Ondan farklı olarak (max+1) elemanlı dizide count(integer) tutmak yerine LinkedList tutuyoruz.
*/
public final class BinBucketSort {
    private BinBucketSort() {}
    
    
    /*
    0 ile max arasında elemanları olan bir dizi verilmişse lineer zamanda sıralanabilir.
    TimeComplexity -> BigTheta(n+max), max -> dizideki en büyük eleman
    Auxiliary Space -> BigTheta(max)
    */
    public static void binBucketSort(Integer[] arr) {
        int n = arr.length;
        int max = CountingSort.findMax(arr);
        LinkedList[] bucketArr = new LinkedList[max+1];
        
        for(int i=0;i<n;i++) {
            if(bucketArr[arr[i]] == null) {
                bucketArr[arr[i]] = new LinkedList(); 
            } 
            bucketArr[arr[i]].add(arr[i]);
        }
        
        
        int j = 0;
        for(int i=0;i<bucketArr.length;i++) {
            if(bucketArr[i] != null) {
                while(!bucketArr[i].isEmpty()) {
                    arr[j++] = (Integer)bucketArr[i].remove(0);
                }
            }
        }
    }
}
