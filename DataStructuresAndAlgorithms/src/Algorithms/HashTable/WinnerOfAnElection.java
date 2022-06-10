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
public class WinnerOfAnElection {
    public static String[] winner(String arr[], int n) {
        HashMap<String,Integer> map = new HashMap<>();
        int maxCount = 0;
        String name="";
        
        for(String s: arr) {
            map.put(s,map.getOrDefault(s,0)+1);
            if(map.get(s) > maxCount) {
                maxCount = map.get(s);
                name = s;
            } else if(map.get(s) == maxCount && s.compareTo(name) < 0) {
                maxCount = map.get(s);
                name = s;
            }
        }
        
        String[] result = {name,""+maxCount};
        return result;
    }   
}
