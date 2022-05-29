/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

/**
 *
 * @author yasir
 */
public final class ShellSort {
    private ShellSort() {}
    
    public static void shellSort(Integer[] arr) {
        int n = arr.length;
        
        //insertion sort ama gap'li. gap seçimi çok farklı şekillerde yapılabilir. burada her defasına 2'ye böldüm
        for(int gap=n/2;gap>=1;gap/=2) {
            for(int i=gap;i<n;i++) {
                int x = arr[i];
                int j = i-gap;
                
                while(j >= 0 && arr[j] > x) {
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                
                arr[j+gap] = x;
            }     
        }
    }
}
