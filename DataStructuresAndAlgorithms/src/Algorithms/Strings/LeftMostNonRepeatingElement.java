/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class LeftMostNonRepeatingElement {
    private static final int CHAR_SIZE = 256;
    
    public static int solution1(String s) {
        int[] counts = new int[CHAR_SIZE];
        
        for(int i=0;i<s.length();i++) {
            counts[s.charAt(i)]++;
        }
        
        for(int i=0;i<s.length();i++) {
            if(counts[s.charAt(i)] == 1)
                return i;
        }
        
        return -1;
    }
    
    public static int solution2(String s) {
        Integer[] indexes = new Integer[CHAR_SIZE];
        int result = s.length();
        
        for(int i=0;i<s.length();i++) {
            if(indexes[s.charAt(i)] == null) { //daha önce hiç karşılaşılmamış
                indexes[s.charAt(i)] = i;
            } else { //daha önce de karşılaşılmış. bu elemanı işaretle
                indexes[s.charAt(i)] = -1;
            }
        }
        
        for(int i=0;i<CHAR_SIZE;i++) {
            if(indexes[i] != null && indexes[i] != -1) {
                result = Math.min(indexes[i], result);
            }
        }
        
        return result;
    }
}
