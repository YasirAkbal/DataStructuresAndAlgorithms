/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingProblems;

/**
 *
 * @author yasir
 * i < j olmak kaydiyla tüm arr[i] > arr[j] şartını sağlayan ikililerin sayısı
 */
public final class CountInversions {
    private CountInversions() {}

    private static long mergeAndCount(long[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        long[] result = new long[right-left+1];
        int index = 0;
        long count = 0;
        
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                result[index] = arr[i];
                i++;
            } else if(arr[i] > arr[j]) {
                result[index] = arr[j];
                j++;
                count += ((mid+1)-i);
            }
            index++;
        }
        
        for(;i<=mid;i++) {
            result[index++] = arr[i];
        }
        
        for(;j<=right;j++) {
            result[index++] = arr[j];
        }
        
        for(int k=left;k<=right;k++) {
            arr[k] = result[k-left];
        }
        
        return count;
    }
    
    private static long mergeSort(long[] arr, int left, int right) {
        long count = 0;
        if(left < right) {
            int mid = (left+right)/2;
            
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid+1, right);
            
            count += mergeAndCount(arr,left,mid,right);
        }
        return count;
    }
    

    public static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr, 0, (int)(N-1));    
    }
    
}
