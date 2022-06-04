/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 */
public final class Closet0s1sAnd2s {
    private Closet0s1sAnd2s() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    public static void segragate012(int arr[], int N){
        int left = 0;
        int mid = 0;
        int right = N-1;
        
        while(mid <= right) {
            if(arr[mid] == 0) {
                util.swap(arr,left,mid);
                left++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {  //arr[mid] == 2 {
                util.swap(arr,mid,right);
                right--;
            }
        }
        
    }
}
