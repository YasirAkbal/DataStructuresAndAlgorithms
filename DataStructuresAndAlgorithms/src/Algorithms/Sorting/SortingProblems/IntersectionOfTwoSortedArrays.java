/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * sıralı iki dizinin kesişiminin alınması(tekrarlı elemanlar 1 kere alınıyor)
 */
public final class IntersectionOfTwoSortedArrays {
    private IntersectionOfTwoSortedArrays() {}

    static ArrayList<Integer> intersection(int arr1[], int arr2[], int n, int m) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastIndex = -1;
        
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] == arr2[j]) {
                if(lastIndex == -1 || result.get(lastIndex) != arr1[i]) {
                    result.add(arr1[i]);
                    lastIndex++;
                }
                i++; j++;
            } else if(arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
            }
        }
        
        return result;
    }
    
}
