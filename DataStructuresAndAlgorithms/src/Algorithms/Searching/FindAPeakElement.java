/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Searching;

/**
 *
 * @author yasir
 */
public final class FindAPeakElement {
    private FindAPeakElement() {}
    
    
    /*verilen dizi sıralı olmadığı halde binary search algoritmasının kullanıldığı ilginç bir problem.
    Time Complexity = BigO(log(n))
    */
    public static int solution(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            
            if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid])) {
                return mid;
            } else if(mid > 0 && arr[mid-1] >= arr[mid]) { //soldaki dizide ara
                right = mid-1;
            } else {
                left = mid+1;
            }
        }  
        //buraya hiç girmez
        return -1;
    }
}
