/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class SubsetSumProblem {
    private SubsetSumProblem() {}
    
    public static int solution1(int[] arr, int sum) {
        if(sum == 0) { return 1; }
        return _solution1(arr, sum, 0);
    }
    
    private static int _solution1(int[] arr, int sum, int i) {
        if(sum == 0) { return 1; }
        if(sum < 0 || i == arr.length) { return 0; }

        /*if(i == arr.length) {
            if(sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }*/
        
        return _solution1(arr,sum-arr[i],i+1) + _solution1(arr,sum,i+1);
    }
}
