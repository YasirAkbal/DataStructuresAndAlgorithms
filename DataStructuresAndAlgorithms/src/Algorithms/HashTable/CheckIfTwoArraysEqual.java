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
public class CheckIfTwoArraysEqual {
    public static boolean check(long A[],long B[],int N) {
        HashMap<Long,Long> map = new HashMap<>();
        
        for(long x: A)
            map.put(x,map.getOrDefault(x,0L)+1);
        
        for(long x: B) { 
            if(!map.containsKey(x)) {
               return false; 
            } else {
                if(map.get(x) == 1) {
                    map.remove(x); 
                } else {
                    map.put(x,map.get(x)-1);  
                }
            }
        }
        
        return map.isEmpty();
    }   
}
