/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

import Utils.ArrayUtils;

/**
 *
 * @author yasir
 */
public final class QuickSort {
    private QuickSort() {}
    
    private static final ArrayUtils<Integer> util = new ArrayUtils<>();
    
    public static void quickSort(Integer[] arr) {
        _quickSort(arr,0,arr.length-1);
    }
    
    private static void _quickSort(Integer[] arr, int left, int right) {
        if(right - left < 1) { return; }
        
        int partitionIndex = partition(arr, left, right);
        
        _quickSort(arr,left,partitionIndex-1); //orjinal hoare partition kullanılacaksa "_quickSort(arr,left,partitionIndex)" olmalı. Çünkü orjinalinde pivot sıralı konumunda değil.
        _quickSort(arr,partitionIndex+1,right);
    }
    
     
    /*
    Hoare Partition yönteminde pivot dizideki uygun(sıralı) konumuna bulunmaz. Sadece pivottan küçük ve eşit elemanların oluşturduğu alt dizinin en son indexini döner...
    Pivot ise bu alt dizinin sağında bulunan ve pivottan büyük ve eşit(eşitlik burada da var) alt dizinin bulunduğu konumda bulunur.
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> BigTheta(1)
    Stable -> Hayır.
    n boyutlu diziyi 1 defa bastan sona geziyor.
    Swap sayısı Lomuto'ya göre daha az.
    Ortalama durumda en performanslı olan partition yöntemi.
    */
    public static int hoarePartition(Integer[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left - 1, j = right + 1;
 
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
 
            do {
                j--;
            } while (arr[j] > pivot);
 
            if (i >= j)
            {
                return j;
            }
            
            util.swap(arr,i,j);
        }
    }
     
    
    /*
    Hoare Partition yönteminden tek farkı tüm dizi tarandıktan sonra pivotun uygun konuma konulması
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> BigTheta(1)
    Stable -> Hayır.
    n boyutlu diziyi 1 defa bastan sona geziyor.
    */
    public static int partition(Integer[] arr, int left, int right) {
        int i=left;
        int j=right;
        int pivot = arr[left];
        
        while(i < j) {
            while(i <= right && arr[i] <= pivot) { i++; }
            while(j > 0 && arr[j] > pivot) { j--; }
            
            if(i < j) {
                util.swap(arr, i, j);
            }
        }
        
        
        //Orjinal hoare partition'dan farkı burası. pivot dizideki uygun(sıralı) konumuna konuluyor.
        arr[left] = arr[j];
        arr[j] = pivot;
        
        return j;
    }
    
    
    /*
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> BigTheta(1)
    Stable -> Hayır.
    n boyutlu diziyi 1 defa bastan sona geziyor.
    Swap sayısı fazla.
    */
    public static int lomutoPartition(Integer[] arr, int left, int right) {
        int i = left-1;
        int pivot = right;
        
        for(int j=left;j<=right-1;j++) {
            if(arr[j] < arr[pivot]) {
                util.swap(arr, ++i, j);
            }
        }
        
        util.swap(arr, i+1, pivot);
        
        return i+1;
    }
    
    
    /*
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> BigTheta(n)
    Stable -> Evet.
    n boyutlu diziyi 4 defa bastan sona geziyor.
    Swap yok.
    */
    public static int naivePartition(Integer[] arr, int left, int right) {
        int[] temp = new int[right-left+1];
        int index = 0;
        int pivot = left;
        
        for(int i=left;i<=right;i++) { //pivottan küçükleri koy
            if(arr[i] < arr[pivot]) {
                temp[index++] = arr[i];
            }
        }
        
        for(int i=left;i<=right;i++) { //pivota eşit olanları koy. Eşit olanlar yeni dizide orjinal dizideki sırasıyla oldugu için stability sağlanıyor.
            if(arr[i] == arr[pivot]) {
                temp[index++] = arr[i];
            }
        }
        
        int partitionIndex = left + index - 1; //partition indexin konumu daha sonra kaybolmaması için bir değişkende tutuluyor
        
        for(int i=left;i<=right;i++) { //pivottan büyükleri pivotun sağına koy
            if(arr[i] > arr[pivot]) {
                temp[index++] = arr[i];
            }
        }
        
        for(int i=left;i<=right;i++) {
            arr[i] = temp[i-left];
        }
        
        return partitionIndex;
    }
    
    
    //Başka problemleri çözmek için pivot elemanını parametre olarak alıyor. Yukarıdaki metotlardan farkı yok.
    public static int partitionWithCustomPivot(Integer[] arr, int left, int right, int pivot) {
        int i=left;
        int j=right;
 
        while(i < j) {
            while(i <= right && arr[i] <= pivot) { i++; }
            while(j > 0 && arr[j] > pivot) { j--; }
            
            if(i < j) {
                util.swap(arr, i, j);
            }
        }
        
        
        return j;
    }
}
