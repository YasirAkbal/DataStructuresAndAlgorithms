/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class ReverseNumber {
    private ReverseNumber() { }
    
    // O(log10(n))
    public static int reverseNumber(int number) {
        int result = 0;
        
        while(number != 0) {
            result = result*10 + number%10;
            number /= 10;
        }
        
        return result;
    }
    
}
