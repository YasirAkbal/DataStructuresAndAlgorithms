/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.BitManipulation;

/**
 *
 * @author yasir
 */
public final class NthBitIsSet {
    private NthBitIsSet() { }
    
    /*
    N. biti en saga getir(LSB) ve onu 1 ile and işlemine sok
    Sonuç 1 ise n. bit 1'dir. 
    BigTheta(log2(n))
    */
    public static boolean withRightShift(int number, int n) {
        return ((number >> (n-1)) & 1) == 1;
    }
    
    public static boolean withLeftShift(int number, int n) {
        return ((1 << (n-1)) & number) != 0;
    }
    
}
