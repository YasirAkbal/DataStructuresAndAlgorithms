/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashMap;

/**
 *
 * @author yasir
 */
public class SubArrayCountWithEq0And1 {
    public static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        
        for(int i=0;i<n;i++) {
            if(arr[i] == 0)
                arr[i] = -1;
        }
        
        //return SubArrayCountWithGivenSum.subArraySum(arr, arr.length, 0); //0 olan sayılar -1 yapılınca bu problem ile çözülebiliyor.
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                result += map.get(sum);
            }
            if(sum == 0) {
                result++;
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return result;
    }   
}
