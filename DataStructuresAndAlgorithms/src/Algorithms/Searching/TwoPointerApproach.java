/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class TwoPointerApproach {
    private TwoPointerApproach() {}

    
    /*
    Verilen sıralı dizide toplamları verilen x sayısına eşit olan çiftin Two Pointer Approach ile bulunması.
    BigO(n)
    */
    public static boolean isPairSum(int[] arr, int x) {
        return _isPairSum(arr,x,0,arr.length-1);
    }
    
    private static boolean _isPairSum(int[] arr, int x, int i, int j) {
        int left = i;
        int right = j;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == x) {
                return true;
            } else if(sum > x) {
                right--;
            } else { //sum < x
                left++;
            }
        }
        
        return false;
    }
    
    public static boolean isTripletSum(int[] arr, int x) {
        int n = arr.length;
        
        for(int i=0;i<n;i++) {
            if(_isPairSum(arr, x-arr[i], i+1, n-1)) {
                return true;
            }
        }
        
        return false;
    }
}
