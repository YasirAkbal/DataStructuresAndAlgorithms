/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author yasir
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */
public class DistinctNumbersInWindow {
    public static ArrayList<Integer> efficientSolution(ArrayList<Integer> A, int B) {
        if(B > A.size())
            return new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<B;i++)
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(map.size());
        for(int i=B;i<A.size();i++) {
            if(map.get(A.get(i-B)) == 1) {
                map.remove(A.get(i-B));
            } else {
                map.put(A.get(i-B),map.get(A.get(i-B))-1);
            }
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
            result.add(map.size());
        }
        
        return result;
    }
}
