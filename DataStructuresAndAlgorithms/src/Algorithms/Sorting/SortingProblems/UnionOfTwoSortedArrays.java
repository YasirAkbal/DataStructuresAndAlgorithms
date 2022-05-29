/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import java.util.ArrayList;

/**
 *
 * @author yasir
 * sıralı iki dizinin birleşiminin alınması(tekrarlı elemanlar 1 kere alınıyor)
 */
public final class UnionOfTwoSortedArrays {
    private UnionOfTwoSortedArrays() {}
    
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastIndex = -1;
        
        while(i < n && j < m) {
            if(lastIndex != -1 && arr1[i] == result.get(lastIndex)) {
                i++;
            } else if(lastIndex != -1 && arr2[j] == result.get(lastIndex)) {
                j++;
            } else if(arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++; lastIndex++;
            } else if(arr1[i] > arr2[j]) {
                result.add(arr2[j]);
                j++; lastIndex++;
            } else {
                result.add(arr1[i]);
                lastIndex++;
                i++; j++;
            }
        }
        
        for(;i<n;i++) {
            if(lastIndex == -1 || result.get(lastIndex) != arr1[i]) {
                result.add(arr1[i]);
                lastIndex++;
            }
        }
        
        for(;j<m;j++) {
            if(lastIndex == -1 || result.get(lastIndex) != arr2[j]) {
               result.add(arr2[j]);
               lastIndex++;
            }
        }
        
        return result;
    }
}
