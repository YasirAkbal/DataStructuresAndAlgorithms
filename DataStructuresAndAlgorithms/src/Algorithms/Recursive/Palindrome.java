/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class Palindrome {
    private Palindrome() { }
    
    public static boolean solution(String str) {
        return _solution(str, 0);
    }
    
    private static boolean _solution(String str, int i) {
        if(i >= str.length()) { return true; }
        
        return (str.charAt(i) == str.charAt(str.length()-i-1)) && _solution(str,i+1);
    }
}
