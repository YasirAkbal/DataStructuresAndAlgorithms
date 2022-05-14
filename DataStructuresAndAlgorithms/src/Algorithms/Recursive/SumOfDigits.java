/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public final class SumOfDigits {
    private SumOfDigits() { }
    
    public static int solution(int n) {
        if(n == 0) { return 0; }
        
        return n%10 + solution(n/10);
    }
}
