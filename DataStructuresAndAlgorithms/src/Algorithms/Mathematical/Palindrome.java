/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class Palindrome {
    private Palindrome() { }
    
    public static boolean isPalindrome(int number) {
        if(number >= 0 && number < 10) { return true; }
        return number == ReverseNumber.reverseNumber(number);
    }
}
