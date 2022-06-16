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
public class Anagram {
    private static final int CHAR_SIZE = 256;
    
    public static boolean solution1(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String s1Sorted = String.valueOf(s1Arr);
        
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s2Arr);
        String s2Sorted = String.valueOf(s2Arr);
        
        return s1Sorted.equals(s2Sorted);
    }
    
    public static boolean solution2(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int[] arr = new int[CHAR_SIZE];
        
        for(int i=0;i<s1.length();i++) {
            arr[s1.charAt(i)]++;
        }
        
        for(int i=0;i<s2.length();i++) {
            if(arr[s2.charAt(i)] == 0)
                return false;
            arr[s2.charAt(i)]--;
        }
        
        return true;
    }
    
    //Çözüm 2'den tek farkı for döngülerinde yapılan işlemler.
    //Daha verimli
    public static boolean solution3(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        int[] arr = new int[CHAR_SIZE];
        
        for(int i=0;i<s1.length();i++) {
            arr[s1.charAt(i)]++;
            arr[s2.charAt(i)]--;
        }
        
        for(int i=0;i<CHAR_SIZE;i++) {
            if(arr[i] != 0)
                return false;
        }
        
        return true;
    }
}
