/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.Arrays;

/**
 *
 * @author yasir
 */
public class LeftMostRepatingCharacter {
    private static final int CHAR_SIZE = 256;
    
    public static int solution(String s) {
        char[] sArr = s.toCharArray();
        int[] counts = new int[CHAR_SIZE];
        
        for(char c: sArr) 
            counts[c]++;
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(counts[c] > 1)
                return i;
        }
        
        return -1;
    }
    
    public static int solution2(String s) {
        Integer[] indexes = new Integer[CHAR_SIZE];
        int result = Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++) {
            int c = s.charAt(i);
            if(indexes[c] != null) {
                result = Math.min(indexes[c],result);
            } else {
                indexes[c] = i;
            }
        }
     
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    //en efektif çözüm
    public static int solution3(String s) {
        boolean[] visited = new boolean[CHAR_SIZE];
        int result = -1;
        
        for(int i=s.length()-1;i>=0;i--) {
            if(visited[s.charAt(i)])
                result = i;
            else
                visited[s.charAt(i)] = true;
        }
        
        return result;
    }
}
