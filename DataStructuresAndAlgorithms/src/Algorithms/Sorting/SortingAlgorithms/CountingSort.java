/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

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
    //Integer, char gibi primitive veri tipleri için
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
    
    
    /*
    0 ile max arasında elemanları olan bir dizi verilmişse lineer zamanda sıralanabilir.
    TimeComplexity -> BigTheta(n+max), max -> dizideki en büyük eleman
    Auxiliary Space -> BigTheta(n+max)
    */
    //Tüm veri tipleri için uyarlanabilir.
    public static void countSortGeneral(Integer[] arr) {
        int n = arr.length;
        int max = findMax(arr);
        Integer[] counts = new Integer[max+1];
        Arrays.fill(counts,0);
        
        for(int number : arr) { //her bir elemanın kaç kere tekrar ettiğini bul
            counts[number]++;
        }
        
        for(int i=1;i<counts.length;i++) { //kümülatif toplam. Her i. eleman için -> arr'de i sayısından küçük veya eşit kaç tane sayı var.
            counts[i] += counts[i-1];
        }
        
        Integer[] output = new Integer[n];
        Arrays.fill(output, 0);
        
        for(int i=n-1;i>=0;i--) { //stable ozelligi saglanmak icin n-1'den baslayarak output dizisini dolduruyoruz. 
            /*
            counts[arr[i]] -> arr[i]'den küçük veya eşit kaç tane eleman var
            output[counts[arr[i]]-1] -> arr[i]'den küçük veya eşit eleman sayısının 1 eksiği arr[i]'nin sıralı konumunu verir.
            Bu sıralı konuma arr[i] değerini koyuyoruz.
            */
            output[counts[arr[i]]-1] = arr[i];
            counts[arr[i]]--; //Bu azaltma işlemi sayesinde arr[i] eğer tekrar ediyorsa tekrar eden sonraki eleman sonraki iterasyonlarda bu elemanın soluna gelecek.
        }
        
        System.arraycopy(output, 0, arr, 0, n); //temp arrayden orjinal arraye kopyalama
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
