/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yasir
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] A1, int[] A2) {
        int N = A1.length;
        int M = A2.length;
        HashMap<Integer,Integer> mapA = new HashMap<>();
        int[] result = new int[N];
        int index = 0;
        
        for(int x: A1)
            mapA.put(x,mapA.getOrDefault(x,0)+1);
        
        for(int x: A2) {
            if(mapA.containsKey(x)) {
                int i = mapA.get(x);
                while(i > 0) {
                    result[index++] = x;
                    i--;
                }
                mapA.remove(x);
            }
        }
        
        ArrayList<Integer> sortedKeys = new ArrayList<>(mapA.keySet());
        Collections.sort(sortedKeys);
        
        
        int[] rightArr = new int[N-index];
        int i = 0;
        for(int key: sortedKeys) {
            int count = mapA.get(key);
            while(count > 0) {
                rightArr[i++] = key; 
                count--;
            }
        }
        
        for(i=index;i<N;i++) {
            result[i] = rightArr[i-index];
        }
        
        return result;
    }  
}
