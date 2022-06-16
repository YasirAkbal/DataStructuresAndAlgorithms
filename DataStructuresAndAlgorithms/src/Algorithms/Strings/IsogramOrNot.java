/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 * Given a string S of lowercase alphabets, check if it is isogram or not. An Isogram is a string in which no letter occurs more than once.
 */
public class IsogramOrNot {
    private static final int CHAR_SIZE = 256;
    
    public static boolean isIsogram(String data){
        int[] counts = new int[CHAR_SIZE];
        
        for(int i=0;i<data.length();i++) {
            counts[data.charAt(i)]++;
            if(counts[data.charAt(i)] > 1)
                return false;
        }
        
        return true;
    }
}
