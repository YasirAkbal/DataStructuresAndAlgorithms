/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;
/**
 *
 * @author yasir
 */
public final class LCM {
    
    private LCM() { }
    
    /*
        LCM = (a*b)/GCD(a,b)
    */
    public int LCMWithEuclid(int a, int b) {
        int gcd = GCD.euclid(a, b);
        
        return (a*b)/gcd;
    }
    
}
