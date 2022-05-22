/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class SearchInRotatedAndSortedArray {
    private SearchInRotatedAndSortedArray() {}
    
    
    /*
    Binary search işlemi yapılıyor. Time Complexity = BigO(log(n))
    Sıralı ve rotate edilmiş bir dizinin her zaman bir yarısı normal sıralı bir diziyken diğeri yarısı sıralı ve rotated edilmiş bir dizi olur
    */
    public static int solution(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            
            if(arr[mid] == x) {
                return mid;
            } else if(arr[left] < arr[mid]) { //left sorted
                if(arr[left] <= x && arr[mid] < x) { //soldaki sıralı dizinin range'i içinde
                    right = mid-1;
                } else { //x, soldaki sıralı dizinin içinde yoksa sağdaki sırasız(rotated) dizide arama yapılır.
                    left = mid+1;
                }
            } else { //right sorted
                if(arr[mid] < arr[right]) { //right sorted
                    if(x > arr[mid] && x <= arr[right]) { //x, sağdaki sıralı dizinin range'i içinde
                        left = mid+1;
                    } else { //x, sağdaki sıralı dizinin range'i içinde değilse soldaki rotated dizidedir ve burada arama yapılır.
                        right = mid-1;
                    }
                }
            }
        }
        
        return -1;
    }
}
