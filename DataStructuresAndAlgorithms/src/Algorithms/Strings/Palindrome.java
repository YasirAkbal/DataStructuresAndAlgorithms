/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class Palindrome {
    public static boolean solution(String s) {
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) 
                return false;
        }
        
        return true;
    }
}
