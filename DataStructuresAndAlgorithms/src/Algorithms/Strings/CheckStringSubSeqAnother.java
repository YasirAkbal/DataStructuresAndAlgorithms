/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class CheckStringSubSeqAnother {
    public static boolean solution(String s1, String s2) {
        if(s1.length() < s2.length())
            return false;
        int j = 0;
        for(int i=0;i<s1.length() && j<s2.length();i++) {
            if(s1.charAt(i) == s2.charAt(j))
                j++;
        }
        
        return s2.length() == j;
    }
}
