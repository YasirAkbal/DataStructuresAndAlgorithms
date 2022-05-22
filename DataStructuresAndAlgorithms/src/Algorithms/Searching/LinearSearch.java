/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

import Utils.ArrayUtils;

/**
 *
 * @author yasir
 */
public final class LinearSearch {
    private LinearSearch() {}
    private ArrayUtils<Integer> utils = new ArrayUtils<>();
    
    /*
    TimeComplexity -> BigO(n)
    
    */
    public int linearSearch(Integer[] arr, int x) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == x) {
                return i;
                //Bahsedilen optimizasyonlar sadece aynı eleman tekrar tekrar arandığında fayda sağlar.
                
                /*optimizasyon-1 -> bulunan elemanı bir sola kaydır. Aynı eleman tekrar arandığında daha az...
                kontrol yapılarak bulunacaktır.
                if(i > 0) {
                    utils.swap(arr, i-1, i);
                    return i-1;
                }
                */
                
                /*optimizasyon-2 : bulunan elemanı dizinin başına getir.
                utils.swap(arr,0,i);
                return 0;
                */
            }
        }
        return -1;
    }
}
