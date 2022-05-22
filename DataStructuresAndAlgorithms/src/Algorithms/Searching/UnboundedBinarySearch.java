/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 * Sonsuz uzunlukta bir dizide x elemanını arama
 * Sonsuz uzunlukta dizi = üst limiti bilinmeyen dizi
 */
public final class UnboundedBinarySearch {
    private UnboundedBinarySearch() {}
    
    
    //BigTheta(log2(position)) -> position: x'in dizideki olası konumu. 
    public static int solution(int[] arr, int x) {
        if(arr[0] == x) { return 0; }
        int i = 1;
        
        //arr[i]'nin x'den büyük olduğu ilk pozisyonu her defasında indisin 2 katını alarak arıyoruz
        //log2(position) 
        while(arr[i] < x) {
            i *= 2;
        }
        
        if(arr[i] == x) { return i; }
        
        //verilen dizinin x'den büyük olduğu ilk 2'nin katı indexi bulmuştik. aradığımız eleman eğer dizide varsa i/2+1 ile i-1 indexleri olmalı. 
        //log2(position*2-position) = log2(position)
        return BinarySearch._recursive(arr, i/2+1, i-1, x);
    } 
}
