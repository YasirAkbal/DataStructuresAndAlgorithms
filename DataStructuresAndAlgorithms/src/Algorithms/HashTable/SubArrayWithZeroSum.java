/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.HashSet;

/**
 *
 * @author yasir
 */
public class SubArrayWithZeroSum { 
    
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> O(n)
    */
    public static boolean findsum(int arr[]) {
        if(arr.length == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int prefixSum = 0;
        
        for(int x : arr) {
            prefixSum += x;
            if(set.contains(prefixSum))
                return true;
            set.add(prefixSum);
        }
        
        return false;
    }
}
