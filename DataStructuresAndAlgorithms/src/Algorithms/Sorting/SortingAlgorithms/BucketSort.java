/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

import Utils.IntArrayUtils;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yasir
 * Bin Sort'a benziyor. Ondan farklı olarak her bir hücre bucket olarak adlandırılıyor ve sayısı parametre olarak veriliyor.
 */
public final class BucketSort {
    private BucketSort() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    
    /*
    Time Complexity -> BigO(n^2)
    Best Case -> BigTheta(n) -> Dizi tam olarak üniform dağılıma sahip ve 'k' dizinin uzunluguna esit veya yakın bir deger secilmis
    Worst Case -> BigTheta(n^2) -> Tum sayilar bir/birakç bucketa toplanmis. Insertion Sort kullandigimizi varsayarsak sıralama maliyeti BigTheta(n^2)
    Auxiliary Space -> BigTheta(n+k)
    Stable
    Adaptive degil
    */
    public static void bucketSort(int[] arr, int k) { //k = bucket sayısı
        ArrayList<Integer>[] buckets = new ArrayList[k];
        int n = arr.length;
        int max = util.max(arr); //Range'i bulmak icin dizideki minimum elemani 0 kabul ettim. Eğer negatif sayı içeren bir diziyse min değeri de bularak range hesaplaması yapılmalı.
        int numCountInEveryBucket = (max+1)/k; //0 ve max da dahil. Dizi üniform dağılmışsa her bucketta tam olarak bu kadar eleman olur.
        int bucketIndex;
        
        for(int i=0;i<n;i++) {
            int temp = (arr[i]/numCountInEveryBucket);
            bucketIndex = (temp < k) ? temp : k-1; //bucketIndex=(k*arr[i])/(max+1)
            if(buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new ArrayList<>();
            }
            buckets[bucketIndex].add(arr[i]);
        }
          
        int index = 0;
        for(int i=0;i<k;i++) {
            ArrayList<Integer> bucket = buckets[i];
            if(bucket != null) {
                Collections.sort(bucket); //Uniform dağılmış bir dizimiz ve her bir buckettaki eleman sayısını düşük tutacak sayıda bucketimiz varsa yani bucketlarımızdaki eleman sayısı azsa(best case) en verimlisi Insertion Sort kullanmak olur.
                for(int num: bucket) {
                    arr[index++] = num;
                }
            }
        }  
    }
}
