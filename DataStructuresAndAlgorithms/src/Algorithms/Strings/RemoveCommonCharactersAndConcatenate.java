/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

import java.util.HashSet;

/**
 *
 * @author yasir
 * Given two strings s1 and s2. Modify both the strings such that all the common characters of s1 and s2 are to be removed and the uncommon characters of s1 and s2 are to be concatenated.
 * Note: If all characters are removed print -1.
 */
public class RemoveCommonCharactersAndConcatenate {
    public static String concatenatedString(String s1,String s2)
    {
        int n = s1.length();
        int m = s2.length();
        StringBuilder sbf = new StringBuilder();
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            set1.add(s1.charAt(i));
        }
        for(int i=0;i<m;i++) {
            set2.add(s2.charAt(i));
        }
        
        for(int i=0;i<n;i++) {
            if(!set2.contains(s1.charAt(i)))
                sbf.append(s1.charAt(i));
        }   
        for(int i=0;i<m;i++) {
            if(!set1.contains(s2.charAt(i)))
                sbf.append(s2.charAt(i));
        }
        
        return sbf.length() == 0 ? "-1" : sbf.toString();
    }
}
